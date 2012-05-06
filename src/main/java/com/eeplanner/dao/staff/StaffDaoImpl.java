package com.eeplanner.dao.staff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.eeplanner.dao.itinerary.ItineraryRowMapper;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.Itinerary;
import com.eeplanner.datastructures.StaffMember;
import com.eeplanner.datastructures.StaffMemberSearchData;
/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 10-Dec-2009
 * Time: 14:57:35
 * To change this template use File | Settings | File Templates.
 */
public class StaffDaoImpl implements StaffDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;
    private HashMap<String, String> sqlQueries;
    Logger log = Logger.getLogger(StaffDaoImpl.class);
    
	public List<StaffMemberSearchData> getStaffMemberSearchData(int staffMemberID, String orderBy) {
        try {

            String qry = sqlQueries.get("getStaffMemberSearchDataByID");

            HashMap params = new HashMap();
            params.put("ID", staffMemberID);
            params.put("orderBy", orderBy);

            List<StaffMemberSearchData> staffMemberSearchData = this.namedParameterJdbcTemplate.query(qry, params, new StaffSearchRowMapper());

            return staffMemberSearchData;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}
	
    public List<StaffMember> getStaffByName(String name, String orderBy) {
        try {

            String qry = sqlQueries.get("getStaffMembersByName");

            HashMap params = new HashMap();
            params.put("name", "%"+name+"%");
            params.put("orderBy", orderBy);

            List<StaffMember> staffMembers = this.namedParameterJdbcTemplate.query(qry, params, new StaffRowMapper());

            return staffMembers;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

	public StaffMember getStaffMemberForCamp(int staffMemberID, int campID) {
        try {

            String qry = sqlQueries.get("getStaffMemberForCamp");

            HashMap params = new HashMap();
            params.put("campID", campID);
            params.put("staffMemberID", staffMemberID);

            StaffMember staffMember = (StaffMember)this.namedParameterJdbcTemplate.queryForObject(qry, params, new CampStaffRowMapper());

            return staffMember;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }
        return null;
    }
	
	public StaffMember getStaffMemberForFlight(Flight flight, int staffMemberID) {
        try {

            String qry = sqlQueries.get("getStaffMemberForFlight");

            HashMap params = new HashMap();
            params.put("flightID", flight.getID());
            params.put("staffMemberID", staffMemberID);

            StaffMember staffMember = (StaffMember)this.namedParameterJdbcTemplate.queryForObject(qry, params, new FlightStaffRowMapper());

            return staffMember;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        } catch (NullPointerException e) {
            log.fatal("null pointer exception..." + e.getMessage());
        } finally {
            return null;
        }
    }

	public List<StaffMember> getStaffMembersForFlight(Flight flight, String orderBy) {
        try {

            String qry = sqlQueries.get("getStaffMembersForFlight");

            HashMap params = new HashMap();
            params.put("flightID", flight.getID());
            params.put("orderBy", orderBy);

            List<StaffMember> staffMembers = this.namedParameterJdbcTemplate.query(qry, params, new FlightStaffRowMapper());

            return staffMembers;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

    public int getStaffMembersCountForCamp(Camp camp) {
        try {

            String qry = sqlQueries.get("getStaffMembersCountForCamp");

            HashMap params = new HashMap();
            params.put("campID", camp.getID());

            int staffMembersCount = this.namedParameterJdbcTemplate.queryForInt(qry, params);

            return staffMembersCount ;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return 0;
        }
    }

    public List<StaffMember> getStaffMembersForCamp(Camp camp, String orderBy) {
        try {

            String qry = sqlQueries.get("getStaffMembersForCamp");

            HashMap params = new HashMap();
            params.put("campID", camp.getID());
            params.put("orderBy", orderBy);

            List<StaffMember> staffMembers = this.namedParameterJdbcTemplate.query(qry, params, new CampStaffRowMapper());

            return staffMembers;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

    public List<StaffMember> getAvailableStaffMembersForCamp(Camp camp, String orderBy) {
        try {

            String qry = sqlQueries.get("getAvailableStaffMembersForCamp");

            HashMap params = new HashMap();
            params.put("start", camp.getStart());
            params.put("end", camp.getEnd());
            params.put("orderBy", orderBy);

            List<StaffMember> staffMembers = this.namedParameterJdbcTemplate.query(qry, params, new StaffRowMapper());

            return staffMembers;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

    public StaffMember getStaffMemberByID(int id) {
        try {

            String qry = sqlQueries.get("getStaffMemberByID");
            StaffMember staffMember = (StaffMember)this.jdbcTemplate.queryForObject(qry, new Object[]{id}, new StaffRowMapper());

            return staffMember;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }
    
    public StaffMember getStaffMemberByHash(String hash) {
        try {

            String qry = sqlQueries.get("getStaffMemberByID");
            qry = StringUtils.replaceOnce(qry, "where s.ID", "where s.HASH");
            List<StaffMember> staffMembers = this.jdbcTemplate.query(qry, new Object[]{hash}, new StaffRowMapper());
			
            if (staffMembers != null && staffMembers.size() > 0) {
				if (staffMembers.size()>1) {
            		for(StaffMember hashedStaff : staffMembers){
						if (hashedStaff.getParentID() != 0) {
            				return hashedStaff;
            			}
            		}
            	}
            	return staffMembers.get(0);
            }

        } catch (DataAccessException e) {
        }
        return null;
    }

    public List<StaffMember> getStaffList(String orderBy, boolean showDeleted, String role) {
        
        try {

            String qry = sqlQueries.get("getStaffMemberList");
            Map params = new HashMap();
            params.put("orderBy", orderBy);
            params.put("showDeleted", showDeleted);
            
            if(StringUtils.isNotBlank(role)){
            	qry = StringUtils.replaceOnce(qry, ":showDeleted)", ":showDeleted) and " + role + " = true");
            }
            
            List<StaffMember> staffMembers = this.namedParameterJdbcTemplate.query(qry, params, new StaffRowMapper());

            return staffMembers;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

    @Transactional
    public boolean setDeleted(int id, boolean isDeleted) {
    	try {
    		Map params = new HashMap();
    		params.put("ID", id);
    		params.put("isDeleted", isDeleted);

    		String qry = sqlQueries.get("setDeleted");
    		this.namedParameterJdbcTemplate.update(qry, params);

    		return true;

    	} catch (DataAccessException e) {
    		log.fatal(e.getMessage());
    		return false;
    	}
    }
    
    @Transactional
    public boolean delete(int id) {
    	try {
    		Map params = new HashMap();
    		params.put("ID", id);

    		String qry = sqlQueries.get("permanentlyDelete");
    		this.namedParameterJdbcTemplate.update(qry, params);

    		return true;

    	} catch (DataAccessException e) {
    		log.fatal(e.getMessage());
    		return false;
    	}
    }
    
    @Transactional
    public StaffMember storeStaffMember(StaffMember staffMember) {


        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(staffMember);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String qry;

        if (staffMember.getID() > 0) {
            qry = sqlQueries.get("editStaffMember");
        } else {
            qry = sqlQueries.get("storeNewStaffMember");
        }

        try {
            this.namedParameterJdbcTemplate.update(qry, fileParameters, keyHolder);
		} catch (DataAccessException e) {
			log.fatal(e.getMessage());
		}

        if (staffMember.getID()==0) staffMember.setID(keyHolder.getKey().intValue());
        return staffMember;
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void setSqlQueries(HashMap<String, String> sqlQueries) {
        this.sqlQueries = sqlQueries;
    }


	public List<StaffMember> getAvailableStaffMembers(int campID, int theYear,String orderBy, boolean showDeleted) {
        try {

            String qry = sqlQueries.get("getAvailableStaffMembers");
            qry += " order by " + orderBy;
            
            HashMap params = new HashMap();
            params.put("orderBy", orderBy);
            params.put("campID", campID);
            params.put("year", theYear);
            params.put("showDeleted", showDeleted);

            List<StaffMember> staffMembers = this.namedParameterJdbcTemplate.query(qry, params, new StaffRowMapper());

            return staffMembers;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}

	public List<Itinerary> getListOfItinerariesForStaffMember(int staffID,
			int theYear) {
		try {

			String qry = sqlQueries.get("getListOfItinerariesForStaffMember");
			
			HashMap params = new HashMap();
			params.put("staffID", staffID);
			params.put("year", theYear);

			List<Itinerary> itinerary = this.namedParameterJdbcTemplate.query(qry, params, new ItineraryRowMapper());

			return itinerary;

		} catch (DataAccessException e) {
			log.fatal(e.getMessage());
			// crap
			return null;
		}
	}


}
