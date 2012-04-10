package com.eeplanner.dao.flight;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.dao.DataAccessException;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.sql.DataSource;

import com.eeplanner.dao.transfer.TransferRowMapper;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.Transfer;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 15-Jan-2010
 * Time: 14:29:16
 * To change this template use File | Settings | File Templates.
 */
public class FlightDaoImpl implements FlightDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private HashMap<String, String> sqlQueries;
    Logger log = Logger.getLogger(FlightDaoImpl.class);

    
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
    
    public Flight getFlightByStaffMemberIDCampID(int staffMemberID, int campID) {
        try {

            Map params = new HashMap();
            params.put("campID", campID);
            params.put("staffMemberID", staffMemberID);

            String qry = sqlQueries.get("getFlightsByCampID");
            Flight flight = (Flight)this.namedParameterJdbcTemplate.queryForObject(qry, params, new FlightRowMapper());

            return flight;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

    public List<Flight> getFlightsByCampID(int campID) {
        try {

            String qry = sqlQueries.get("getFlightsByCampID");
            List<Flight> flights = this.jdbcTemplate.query(qry, new Object[]{campID}, new FlightRowMapper());

            return flights;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

    public Flight getFlightByID(int id) {
        try {

            String qry = sqlQueries.get("getFlightByID");
            Flight flight = (Flight) this.jdbcTemplate.queryForObject(qry, new Object[]{id}, new FlightRowMapper());

            return flight;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }


    public List<Flight> getFlightListByStaffMemberID(int staffMemberID, String orderBy) {
        try {
            Map params = new HashMap();
            params.put("staffMemberID", staffMemberID);
            params.put("orderBy", orderBy);

            String qry = sqlQueries.get("getFlightListByStaffMemberID");
            List<Flight> flights = this.namedParameterJdbcTemplate.query(qry, params, new FlightRowMapper());

            return flights;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

    public List<Flight> getFlightList(String orderBy, boolean showDeleted) {

        try {

    		Map params = new HashMap();
    		params.put("orderBy", orderBy);
    		params.put("showDeleted", showDeleted);
            String qry = sqlQueries.get("getFlightList");
            List<Flight> flights = this.namedParameterJdbcTemplate.query(qry, params, new FlightRowMapper());

            return flights;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }



    public List<Flight> getFlightListByYear(String orderBy, boolean showDeleted, int year) {

        try {

    		Map params = new HashMap();
    		params.put("orderBy", orderBy);
    		params.put("showDeleted", showDeleted);
    		params.put("year", year);
            String qry = sqlQueries.get("getFlightListByYear");
            List<Flight> flights = this.namedParameterJdbcTemplate.query(qry, params, new FlightRowMapper());

            return flights;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }




    public Flight storeFlight(Flight flight) {

        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(flight);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String qry;

        if (flight.getID() > 0) {
            qry = sqlQueries.get("editFlight");
        } else {
            qry = sqlQueries.get("storeNewFlight");
        }

        try {
            this.namedParameterJdbcTemplate.update(qry, fileParameters, keyHolder);
        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }

        if (flight.getID() == 0) flight.setID(keyHolder.getKey().intValue());
        return flight;
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void setSqlQueries(HashMap<String, String> sqlQueries) {
        this.sqlQueries = sqlQueries;
    }
    
    public boolean removeFlight(int id) 
	{
		try
		{
			Map params = new HashMap();
			params.put("ID", id);
	
			String qry = sqlQueries.get("removeFlight");
			this.namedParameterJdbcTemplate.update(qry, params);
	
			return true;

		} catch (DataAccessException e) {
		log.fatal(e.getMessage());
		return false;
		}
	}
	
	public boolean removeAllFlights()
	{
		try {
			Map params = new HashMap();

			String qry = sqlQueries.get("removeAllFlights");
			this.namedParameterJdbcTemplate.update(qry, params);

			return true;

		} catch (DataAccessException e) {
			log.fatal(e.getMessage());
			return false;
		}
	 
	}
	public List<Flight> getFlightsByItineraryID(int itineraryID)
	{
        try {

            String qry = sqlQueries.get("getFlightsByItineraryID");
            List<Flight> flights = this.jdbcTemplate.query(qry, new Object[]{itineraryID}, new FlightRowMapper());

            return flights;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }	
		
	}
	public List<Flight> getFlightsByCampAndStaffID(int campID, int staffID)
	{       
        try {

            String qry = sqlQueries.get("getFlightByCampAndStaffID");

            HashMap params = new HashMap();
            params.put("campID", campID);
            params.put("staffID", staffID);
            
            List<Flight> flights = this.namedParameterJdbcTemplate.query(qry, params, new FlightRowMapper());

            return flights;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}
}
