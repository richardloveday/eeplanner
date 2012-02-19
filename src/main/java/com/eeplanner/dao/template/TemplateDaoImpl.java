package com.eeplanner.dao.template;

import java.util.Date;
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

import com.eeplanner.datastructures.Template;
import com.eeplanner.datastructures.TemplateType;

public class TemplateDaoImpl implements TemplateDao {

	private Logger log = Logger.getLogger(getClass());

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private HashMap<String, String> sqlQueries;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void setSqlQueries(HashMap<String, String> sqlQueries) {
		this.sqlQueries = sqlQueries;
	}

	public List<Template> getTemplates() {
		try {

			Map<String, Object> params = new HashMap<String, Object>();
			String qry = sqlQueries.get("getTemplateList");
			List<Template> templates = this.namedParameterJdbcTemplate.query(qry, params, new TemplateRowMapper());

			return templates;
		} catch (DataAccessException e) {
			log.fatal(e.getMessage());
			return null;
		}
	}

	public Template storeTemplate(Template template) {
		SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(template);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String qry;
        
        if (template.getID() > 0) {
            qry = sqlQueries.get("editTemplate");
        } else {
            qry = sqlQueries.get("storeNewTemplate");
        }
        
        template.setEditedDate(new Date());

        try {
            this.namedParameterJdbcTemplate.update(qry, fileParameters, keyHolder);
        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }

        if (template.getID() == 0) {
        	template.setID(keyHolder.getKey().intValue());
        }

        return template;
	}

	public Template getTemplateById(int id) {
		try {

			String qry = sqlQueries.get("getTemplateByID");
			Template template = (Template) this.jdbcTemplate.queryForObject(qry, new Object[]{id}, new TemplateRowMapper());

			return template;

		} catch (DataAccessException e) {
			log.fatal(e.getMessage());
			return null;
		}
	}

	public Template getTemplateByType(String type) {
		try {

			String qry = sqlQueries.get("getTemplateByType");
			Template template = (Template) this.jdbcTemplate.queryForObject(qry, new Object[]{type}, new TemplateRowMapper());

			return template;

		} catch (DataAccessException e) {
			log.fatal(e.getMessage());
			return null;
		}
	}

}
