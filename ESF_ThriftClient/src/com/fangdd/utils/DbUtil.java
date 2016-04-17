package com.fangdd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DbUtil {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String dbDriver = null;
	private String dbConnectionURL = null;
	private String dbUsername = null;
	private String dbPassword = null;
	private PropUtil PropUtil = new PropUtil("config/db.properties");
	private Logger logger = Logger.getLogger(DbUtil.class);

	public DbUtil() {
		dbDriver = PropUtil.get("Driver");
		dbConnectionURL = PropUtil.get("ConnectionURL");
		dbUsername = PropUtil.get("Username");
		dbPassword = PropUtil.get("Password");
	}

	public DbUtil(String dbDriver, String dbConnectionURL, String dbUsername,
			String dbPassword) {
		this.dbDriver = dbDriver;
		this.dbConnectionURL = dbConnectionURL;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}

	/**
	 * 功能：获取数据库连接
	 */
	public Connection getConnection() {
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbConnectionURL, dbUsername,
					dbPassword);
		} catch (Exception e) {
			logger.error("Error: DbUtil.getConnection() 获得数据库链接失败.\r\n链接类型:"
					+ dbDriver + "\r\n链接URL:" + dbConnectionURL + "\r\n链接用户:"
					+ dbUsername + "\r\n链接密码:" + dbPassword, e);
		}
		return conn;
	}

	/**
	 * 功能：执行查询语句
	 */
	public ResultSet executeQuery(String sql) {
		logger.debug("exec sql:" + sql);
		getConnection();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			logger.error("执行DbUtil.executeQuery()方法发生异常，异常信息：", e);
		}
		return rs;
	}

	/**
	 * 功能：执行查询语句，获取记录数
	 */
	public int getRecordCount(String sql) {
		logger.debug("exec sql:" + sql);
		int counter = 0;
		getConnection();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				counter++;
			}
		} catch (SQLException e) {
			logger.error("执行DbUtil.getRecordCount()方法发生异常，异常信息：", e);
		}
		close();
		return counter;
	}

	/**
	 * 功能:执行更新操作
	 */
	public int executeUpdate(String sql) {
		logger.debug("exec sql:" + sql);
		int result = 0;
		getConnection();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			logger.error("执行DbUtil.executeUpdate()方法发生异常，异常信息：", e);
		}
		close();
		return result;
	}

	/**
	 * 功能:关闭数据库的连接
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			logger.error("执行DbUtil.close()方法发生异常，异常信息：", e);
		}
	}
}
