package com.eeplanner.dao.itinerary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.Itinerary;
import com.eeplanner.datastructures.Transfer;
import com.eeplanner.dao.flight.*;
import com.eeplanner.dao.transfer.*;
import com.eeplanner.web.staff.StaffMemberController;

public class ItineraryDaoImpl implements ItineraryDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private HashMap<String, String> sqlQueries;
    Logger log = Logger.getLogger(StaffMemberController.class);

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
                dataSource);
    }

    public void setSqlQueries(HashMap<String, String> sqlQueries) {
        this.sqlQueries = sqlQueries;
    }

    @Transactional
    public Itinerary storeItinerary(Itinerary itinerary) {

        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(itinerary);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String qry;

        if (itinerary.getID() > 0) {
            qry = sqlQueries.get("editItinerary");
        } else {
            qry = sqlQueries.get("storeNewItinerary");
        }

        try {
            this.namedParameterJdbcTemplate.update(qry, fileParameters,
                    keyHolder);
        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }

        if (itinerary.getID() == 0)
            itinerary.setID(keyHolder.getKey().intValue());
        return itinerary;
    }



    public Itinerary getItineraryByID(int id) {
        try {

            String qry = sqlQueries.get("getItineraryByID");
            Itinerary itinerary = (Itinerary) this.jdbcTemplate.queryForObject(qry, new Object[]{id}, new ItineraryRowMapper());

            return itinerary;

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

            String qry = sqlQueries.get("deleteItinerary");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
    }

	public Itinerary getItineraryByCampAndStaffID(int campID, int staffMemberID) {
		try {

            String qry = sqlQueries.get("getItineraryByCampAndStaffID");
            Itinerary itinerary = (Itinerary) this.jdbcTemplate.queryForObject(qry, new Object[]{campID, staffMemberID }, new ItineraryRowMapper());

            return itinerary;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}
	
	public List<Itinerary> getItineraryByCampID(int campID) {
		try {

            String qry = sqlQueries.get("getItineraryByCampID");
            List<Itinerary> itineraryList = this.jdbcTemplate.query(qry, new Object[]{campID}, new ItineraryRowMapper());

            return itineraryList;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}
	
	public Itinerary getItineraryByFlightAndStaffID(int flightID, int staffMemberID) {
		try {

            String qry = sqlQueries.get("getItineraryByFlightAndStaffID");
            Itinerary itinerary = (Itinerary) this.jdbcTemplate.queryForObject(qry, new Object[]{flightID, staffMemberID }, new ItineraryRowMapper());

            return itinerary;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
	}

}
