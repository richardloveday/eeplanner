package com.eeplanner.service;

import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseDumpTool {

	private static StringBuilder sql;
	private static Connection connection;
	private static DataSource dataSource;

	public DatabaseDumpTool(DataSource dataSource) throws SQLException {
		DatabaseDumpTool.dataSource = dataSource;
	}

	public static String dump() throws SQLException {

		connection = dataSource.getConnection();

		sql = new StringBuilder();

		String timestamp = new SimpleDateFormat("MMdd-hhmmss").format(new Date());

		sql.append("\n").append("---- sql dump from eeplanner on ").append(timestamp).append("----");

		DatabaseMetaData metadata = connection.getMetaData();
		String[] types = {"TABLE"};
		ResultSet rs = metadata.getTables(
				null, null, null, types);
		while (rs.next()) {
			String tableName = rs.getString("TABLE_NAME");
			listTable(tableName);
		}

		return sql.toString();

	}

	private static void listTable(String tableName) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(
				"select * from " + tableName + " a");

		sql.append("\n").append("----").append(tableName).append("----");

		int rowNo = 0;
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			if (rowNo == 0)
				printTableColumns(rs);
			printResultRow(rs);
			rowNo++;
		}
	}

	private static void printTableColumns(ResultSet rs)
			throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		for (int i = 0; i < metaData.getColumnCount(); i++) {
			int col = i + 1;
			sql.append("\n")
					.append(metaData.getColumnName(col))
					.append(" ")
					.append(metaData.getColumnTypeName(col))
					.append(" ")
					.append("(")
					.append(metaData.getPrecision(col))
					.append(")");
		}
		sql.append("\n");
	}

	private static void printResultRow(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		for (int i = 0; i < metaData.getColumnCount(); i++) {
			String column = metaData.getColumnName(i + 1);
			try {
				String value = rs.getString(column);
				if (value != null && !value.equals("null")
						&& !value.equals("") && !value.equals("0"))
					sql.append("\n")
							.append(column)
							.append(": ")
							.append(value)
							.append(", ");
			} catch (SQLException e) {
				sql.append("\n")
						.append(column)
						.append(": ")
						.append(e.getMessage());
			}
		}
		sql.append("\n");
	}
}