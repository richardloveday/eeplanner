package com.eeplanner.dao.staffavailability;

import com.eeplanner.datastructures.StaffAvailability;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.dao.DataAccessException;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

public class StaffAvailabilityDaoImpl implements StaffAvailabilityDao {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private HashMap<String, String> sqlQueries;
    Logger log = Logger.getLogger(StaffAvailabilityDao.class);
    
	public StaffAvailability getStaffAvailabilityByIDAndYear(int staffID, int year) {
		
        try {

            String qry = sqlQueries.get("getStaffAvailabilityByIDAndYear");
            StaffAvailability staffAvailability = (StaffAvailability) this.jdbcTemplate.queryForObject(qry, new Object[]{staffID, year}, new StaffAvailabilityRowMapper());

            return staffAvailability;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}

	@Transactional
	public void createNewStaffAvailabilityForStaff(int staffID, int theYear) {
        try {
    		Map params = new HashMap();
    		params.put("ID", staffID);
    		params.put("year", theYear);
    		params.put("available1", 0);
    		params.put("available2", 0);
    		params.put("available3", 0);
    		params.put("available4", 0);
    		params.put("available5", 0);
    		params.put("available6", 0);
    		params.put("available7", 0);
    		params.put("note", null);

            String qry = sqlQueries.get("createNewStaffAvailabilityForStaff"); 
            this.namedParameterJdbcTemplate.update(qry, params);

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
        }
	}

	@Transactional
	public void storeStaffAvailability(StaffAvailability staffAvailability) {

        try {
    		Map params = new HashMap();
    		params.put("ID", staffAvailability.getStaffID());
    		params.put("year", staffAvailability.getYear());
    		params.put("available1", staffAvailability.isAvailable1());
    		params.put("available2", staffAvailability.isAvailable2());
    		params.put("available3", staffAvailability.isAvailable3());
    		params.put("available4", staffAvailability.isAvailable4());
    		params.put("available5", staffAvailability.isAvailable5());
    		params.put("available6", staffAvailability.isAvailable6());
    		params.put("available7", staffAvailability.isAvailable7());
    		params.put("note", staffAvailability.getNote());

            String qry = sqlQueries.get("editStaffAvailability"); 
            int count = this.namedParameterJdbcTemplate.update(qry, params);
			if (count == 0) {
            	this.createNewStaffAvailabilityForStaff(staffAvailability.getStaffID(), staffAvailability.getYear());
            	
            	this.namedParameterJdbcTemplate.update(qry, params);
            }

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }
	}
	

    public void setDataSource(DataSource dataSource) {
    	this.jdbcTemplate = new JdbcTemplate(dataSource);
    	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void setSqlQueries(HashMap<String, String> sqlQueries) {
        this.sqlQueries = sqlQueries;
    }

    @Transactional
	public void deleteAvailabilityForStaff(int staffId) {
		 try {
	            Map params = new HashMap();
	            params.put("staffID", staffId);

	            String qry = sqlQueries.get("removeAvailabilities");
	            this.namedParameterJdbcTemplate.update(qry, params);

	        } catch (DataAccessException e) {
	            log.fatal(e.getMessage());
	        }		
	}
    
	
}