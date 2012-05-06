package com.eeplanner.dao.transfer;

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

import com.eeplanner.dao.flight.FlightRowMapper;
import com.eeplanner.dao.staff.StaffSearchRowMapper;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.StaffMemberSearchData;
import com.eeplanner.datastructures.Transfer;
import com.eeplanner.web.staff.StaffMemberController;

public class TransferDaoImpl implements TransferDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private HashMap<String, String> sqlQueries;
    Logger log = Logger.getLogger(StaffMemberController.class);

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void setSqlQueries(HashMap<String, String> sqlQueries) {
        this.sqlQueries = sqlQueries;
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
    public Transfer storeTransfer(Transfer transfer) {
        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(transfer);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String qry;

        if (transfer.getID() > 0) {
            qry = sqlQueries.get("editTransfer");
        } else {
            qry = sqlQueries.get("storeNewTransfer");
        }

        try {
            this.namedParameterJdbcTemplate.update(qry, fileParameters, keyHolder);
        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }

        if (transfer.getID() == 0) {
            transfer.setID(keyHolder.getKey().intValue());
        }

        return transfer;
    }


    public Transfer getTransferByID(int id) {

        try {

            String qry = sqlQueries.get("getTransferByID");
            Transfer transfer = (Transfer) this.jdbcTemplate.queryForObject(qry, new Object[]{id}, new TransferRowMapper());

            return transfer;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }

    }

    public List<Transfer> getTransfersByItineraryID(int itineraryID) {
        try {

            String qry = sqlQueries.get("getTransferByItineraryID");
            List<Transfer> transfers = this.jdbcTemplate.query(qry, new Object[]{itineraryID}, new TransferRowMapper());

            return transfers;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }

    }

    public List<Transfer> getTransferList(String orderBy, boolean showDeleted) {

        try {

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("orderBy", orderBy);
            params.put("showDeleted", showDeleted);
            String qry = sqlQueries.get("getTransferList");
            List<Transfer> transfers = this.namedParameterJdbcTemplate.query(qry, params, new TransferRowMapper());

            return transfers;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }


    public List<Transfer> getTransferListByYear(String orderBy, boolean showDeleted, int year) {

        try {

            Map params = new HashMap();
            params.put("orderBy", orderBy);
            params.put("showDeleted", showDeleted);
            params.put("year", year);
            String qry = sqlQueries.get("getTransferListByYear");
            List<Transfer> transfers = this.namedParameterJdbcTemplate.query(qry, params, new TransferRowMapper());

            return transfers;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            // crap
            return null;
        }
    }

}
