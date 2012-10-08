package com.eeplanner.dao.camp;

import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.CampStaff;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampDaoImpl implements CampDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private HashMap<String, String> sqlQueries;
    Logger log = Logger.getLogger(CampDaoImpl.class);



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
    public List<Camp> getAvailableCampsForTransfer(int transferID, String orderBy, boolean includeDeleted)
    {
    	try {

            String qry = sqlQueries.get("getAvailableCampsByTransferID");

            HashMap params = new HashMap();
            params.put("ID", transferID);
            params.put("orderBy", orderBy);
            params.put("includeDeleted", includeDeleted);

            List<Camp> camps = this.namedParameterJdbcTemplate.query(qry, params, new CampRowMapper());

            return camps;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }
	public List<Camp> getAvailableCampsForFlight(int flightID, String orderBy, boolean includeDeleted) {
        try {

            String qry = sqlQueries.get("getAvailableCampsByFlightID");

            HashMap params = new HashMap();
            params.put("ID", flightID);
            params.put("orderBy", orderBy);
            params.put("includeDeleted", includeDeleted);

            List<Camp> camps = this.namedParameterJdbcTemplate.query(qry, params, new CampRowMapper());

            return camps;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}
	public List<Camp> getCampsForTransfer(int transferID, String orderBy)
	{
        try {

            String qry = sqlQueries.get("getCampsByTransferID");

            HashMap params = new HashMap();
            params.put("ID", transferID);
            params.put("orderBy", orderBy);

            List<Camp> camps = this.namedParameterJdbcTemplate.query(qry, params, new CampRowMapper());

            return camps;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}
	public List<Camp> getCampsForFlight(int flightID, String orderBy) {
        try {

            String qry = sqlQueries.get("getCampsByFlightID");

            HashMap params = new HashMap();
            params.put("ID", flightID);
            params.put("orderBy", orderBy);

            List<Camp> camps = this.namedParameterJdbcTemplate.query(qry, params, new CampRowMapper());

            return camps;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}

	@Transactional
    public boolean removeCampStaffMember(int campID, int staffMemberID) {

        try {
            Map params = new HashMap();
            params.put("campID", campID);
            params.put("staffMemberID", staffMemberID);

            String qry = sqlQueries.get("removeCampStaffMember");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
    }

	@Transactional
	public boolean removeAllCampStaffMembers(int campID) {

        try {
            Map params = new HashMap();
            params.put("campID", campID);

            String qry = sqlQueries.get("removeAllCampStaffMembers");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
	}

    public List<Camp> getCampsByStaffMemberID(int staffMemberID, String orderBy) {

            try {

                String qry = sqlQueries.get("getCampsByStaffMemberID");

                HashMap params = new HashMap();
                params.put("ID", staffMemberID);
                params.put("orderBy", orderBy);

                List<Camp> camps = this.namedParameterJdbcTemplate.query(qry, params, new CampRowMapper());

                return camps;

            } catch (DataAccessException e) {
                log.fatal(e.getMessage());
                // crap
                return null;
            }
    }

    public List<Camp> getCampsByName(String name) {

            try {

                String qry = sqlQueries.get("getCampsByName");

                HashMap params = new HashMap();
                params.put("name", "%"+name+"%");
                params.put("orderBy", "secondName asc");

                List<Camp> camps = this.namedParameterJdbcTemplate.query(qry, params, new CampRowMapper());

                return camps;

            } catch (DataAccessException e) {
                log.fatal(e.getMessage());
                // crap
                return null;
            }
        }

    @Transactional
	public boolean editCampStaffMember(CampStaff campStaff) {
        try {

        	if("0".equalsIgnoreCase(campStaff.getJob())) {
        		campStaff.setJob(null);
        	}

        	Map params = new HashMap();
            params.put("campID", campStaff.getCampID());
            params.put("staffMemberID", campStaff.getStaffID());
            params.put("offered", campStaff.isOffered());
            params.put("accepted", campStaff.isAccepted());
            params.put("returned", campStaff.isReturned());
            params.put("job", campStaff.getJob());
            params.put("contractDate", campStaff.getContractDate());

            String qry = sqlQueries.get("editCampStaffMember");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
    }

    @Transactional
    public boolean addCampStaffMember(int campID, int staffMemberID) {

        try {
            Map params = new HashMap();
            params.put("campID", campID);
            params.put("staffID", staffMemberID);

            String qry = sqlQueries.get("addCampStaffMember");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
    }


    public Camp getCampByID(int id) {
        try {

            String qry = sqlQueries.get("getCampByID");
            Camp staffMember = (Camp) this.jdbcTemplate.queryForObject(qry, new Object[]{id}, new CampRowMapper());

            return staffMember;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

    public List<Camp> getCampList(String orderBy, boolean includeDeleted) {

        try {
    		Map params = new HashMap();
    		params.put("orderBy", orderBy);
    		params.put("includeDeleted", includeDeleted);
            String qry = sqlQueries.get("getCampList");
            List<Camp> camps = this.namedParameterJdbcTemplate.query(qry, params, new CampRowMapper());

            return camps;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

    public List<Camp> getCampListWithStaff(String orderBy, boolean includeDeleted) {

        try {
    		Map params = new HashMap();
    		params.put("orderBy", orderBy);
    		params.put("includeDeleted", includeDeleted);
            String qry = sqlQueries.get("getCampListWithStaffNumbers");
            List<Camp> camps = (List<Camp>) this.namedParameterJdbcTemplate.query(qry, params, new CampWithStaffResultSetExtractor());

            return camps;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

    public List<Camp> getCampListWithStaffWithYear(String orderBy, boolean includeDeleted, int theYear) {

        try {
    		Map params = new HashMap();
    		params.put("orderBy", orderBy);

    		/*DateTime startDate2 = ;
    		DateTime endDate2 = new DateTime(theYear,12,31, 0, 0, 0, 0).toDate();
    		Date startDate = startDate2.toDate();
    		Date endDate = endDate2.toDate();
    		*/
    		params.put("startDate", new DateTime(theYear,1,1, 0, 0, 0, 0).toDate());
    		params.put("endDate", new DateTime(theYear,12,31, 0, 0, 0, 0).toDate());
    		params.put("includeDeleted", includeDeleted);
            String qry = sqlQueries.get("getCampListWithStaffNumbersAndYear");
            List<Camp> camps = (List<Camp>) this.namedParameterJdbcTemplate.query(qry, params, new CampWithStaffResultSetExtractor());

            return camps;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }
    
    @Transactional
    public Camp storeCamp(Camp camp) {

        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(camp);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String qry;

        if (camp.getID() > 0) {
            qry = sqlQueries.get("editCamp");
        } else {
            qry = sqlQueries.get("storeNewCamp");
        }

        try {
            this.namedParameterJdbcTemplate.update(qry, fileParameters, keyHolder);
        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }

        if (camp.getID() == 0) camp.setID(keyHolder.getKey().intValue());
        return camp;
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void setSqlQueries(HashMap<String, String> sqlQueries) {
        this.sqlQueries = sqlQueries;
    }

	public HashMap<String, Object> getCampSearchData(int campID, String orderBy) {

       try {
    		Map params = new HashMap();
    		params.put("orderBy", orderBy);
    		params.put("includeDeleted", false);
            String qry = sqlQueries.get("getCampSearchDataByCampName");
            HashMap<String, Object> campMap = (HashMap<String, Object>) this.namedParameterJdbcTemplate.query(qry, params, new CampWithStaffResultSetExtractor());

            return campMap;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}
	public CampStaff getCampStaff(int campId, int staffId) {

		try {

            String qry = sqlQueries.get("getCampStaff");
            CampStaff campStaff = (CampStaff) this.jdbcTemplate.queryForObject(qry, new Object[]{campId, staffId}, new CampStaffRowMapper());

            return campStaff;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}
	public List<Camp> getCampsForYear(int startYear) {
		try {

            String qry = sqlQueries.get("getCampsByYear");

            HashMap params = new HashMap();
            params.put("startYear", startYear);

            List<Camp> camps = this.namedParameterJdbcTemplate.query(qry, params, new CampRowMapper());

            return camps;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return null;
        }
	}


}
