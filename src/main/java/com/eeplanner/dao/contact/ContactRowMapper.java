package com.eeplanner.dao.contact;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.eeplanner.datastructures.Contact;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 08-Dec-2009
 * Time: 16:17:06
 * To change this template use File | Settings | File Templates.
 */
public class ContactRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact(rs.getInt("ID"), rs.getString("firstNames"), rs.getString("secondName"),
                rs.getString("orgName"), rs.getString("add1"), rs.getString("add2"), rs.getString("add3"),
                rs.getString("add4"), rs.getString("postCode"), rs.getString("type"),
                rs.getDate("dob"), rs.getInt("relatedID"), rs.getString("sex"));

        contact.setAccountHolderName(rs.getString("accountHolderName"));
        contact.setAccountNumber(rs.getString("accountNumber"));
        contact.setAccountSortCode(rs.getString("accountSortCode"));
        contact.setNationalInsuranceNumber(rs.getString("nationalInsuranceNumber"));
        contact.setStudent(rs.getBoolean("student"));
        
        return contact;
    }
}
