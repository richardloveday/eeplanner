package com.eeplanner.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DatabaseDumpTool {

	private static Connection connection;
	private static DataSource dataSource;
	private static File file;

	public DatabaseDumpTool(DataSource dataSource) throws SQLException, IOException {

		DatabaseDumpTool.dataSource = dataSource;
		file = new ClassPathResource("backup/eeplanner.bak.sql").getFile();

	}

	public static void dump() throws SQLException, IOException {

		FileOutputStream fos = new FileOutputStream(file, true);

		connection = dataSource.getConnection();

		String timestamp = new SimpleDateFormat("dd-MM-yyyy-hhmm").format(new Date());

		fos.write(("\n" + "-- sql dump from eeplanner on " + timestamp + " --\n\n\n").getBytes());

		DatabaseMetaData metadata = connection.getMetaData();
		String[] types = {"TABLE"};
		ResultSet rs = metadata.getTables(null, null, null, types);
		while (rs.next()) {
			String tableName = rs.getString("TABLE_NAME");

			addTableInsertStatement(tableName, fos);
			addRowInsertStatements(tableName, fos);
		}


		fos.close();

	}

	private static void addRowInsertStatements(String tableName, FileOutputStream fos) throws SQLException, IOException {
		PreparedStatement statement = connection.prepareStatement(
				"select * from " + tableName + " a"
		);

		ResultSet rs = statement.executeQuery();

		Map<String, String> columns = new LinkedHashMap<String, String>();

		for (int i = 1; i < rs.getMetaData().getColumnCount(); i++) {
			columns.put(rs.getMetaData().getColumnName(i), rs.getMetaData().getColumnTypeName(i));
		}

		fos.write(("\n" + "-- " + " insert row data for " + tableName + " --\n\n").getBytes());
		fos.write(("INSERT INTO `" + tableName + "` (").getBytes());

		fos.write(StringUtils.join(columns.keySet().toArray(), ",").getBytes());

		fos.write((") VALUES ").getBytes());

		List<String> rows = new ArrayList<String>();

		while (rs.next()) {

			fos.write("\n(".getBytes());

			for (int i = 1; i < rs.getMetaData().getColumnCount(); i++) {

				String columnType = (String) columns.values().toArray()[i - 1];
				byte[] value = rs.getBytes(i);

				if (value == null) {
					value = "NULL".getBytes();
				}

				switch (ColumnTypes.valueOf(columnType.replace(' ', '_'))) {
					case TINYINT: {
						fos.write(value);
						break;
					}
					case INT: {
						fos.write(value);
						break;
					}
					case INT_UNSIGNED: {
						fos.write(value);
						break;
					}
					case TINYINT_UNSIGNED: {
						fos.write(value);
						break;
					}
					default: {
						fos.write("'".getBytes());
						fos.write(value);
						fos.write("'".getBytes());
						break;
					}
				}
				if (i < rs.getMetaData().getColumnCount() - 1) {
					fos.write(",".getBytes());
				} else {
					fos.write(")".getBytes());
					if (rs.isLast()) {
						fos.write(";\n\n\n".getBytes());
					} else {
						fos.write(",".getBytes());
					}
				}
			}
		}


	}

	private static void addTableInsertStatement(String tableName, FileOutputStream fos) throws SQLException, IOException {

		fos.write(("-- create table " + tableName + " --\n").getBytes());

		PreparedStatement statement = connection.prepareStatement(
				"SHOW CREATE TABLE " + tableName + ";"
		);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			fos.write((rs.getString(2) + " ;" + "\n\n").getBytes());
		}

	}

	enum ColumnTypes {

		TINYINT_UNSIGNED("TINYINT"),
		TINYINT("TINYINT"),
		INT_UNSIGNED("INT UNSIGNED"),
		INT("INT"),
		VARCHAR("VARCHAR"),
		DATETIME("DATETIME"),
		DATE("DATE"),
		DECIMAL("DECIMAL"),
		TIMESTAMP("TIMESTAMP"),
		CHAR("CHAR");

		private String value;

		ColumnTypes(String value) {
			this.value = value;
		}
	}
}