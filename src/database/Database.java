package database;

import java.sql.*;

/**
 *
 * The Database class is a singleton class that represents our database connection
 *
 * @author James DiNovo
 * @date 24.10.2018
 * @version 1.0
 *
 */
public class Database {
	//create private instance variable
	private static Database instance = null;
	private Connection connection = null;
	//create private constructor
	private Database() {
		if(connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://" + DBConst.getDbHost() + "/" + DBConst.getDbName() + "?useSSL=false", DBConst.getDbUser(), DBConst.getDbPass());
				System.out.println("Successfully Created Connection");
			} catch(Exception e) {
				e.printStackTrace();

			}
			try {
				createTable(DBConst.TABLE_CUSTOMERS, DBConst.CREATE_TABLE_CUSTOMERS, connection);
				createTable(DBConst.TABLE_VEHICLES, DBConst.CREATE_TABLE_VEHICLES, connection);
				createTable(DBConst.TABLE_WORKORDERS, DBConst.CREATE_TABLE_WORKORDERS, connection);
				createTable(DBConst.TABLE_CUSTOMER_VEHICLES, DBConst.CREATE_TABLE_CUSTOMER_VEHICLES, connection);
				createTable(DBConst.TABLE_VEHICLE_WORKORDERS, DBConst.CREATE_TABLE_VEHICLE_WORKORDERS, connection);
				createTable(DBConst.TABLE_CUSTOMER_VEHICLE_ISSUE, DBConst.CREATE_TABLE_CUSTOMER_VEHICLE_ISSUE, connection);
			} catch(SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 *
	 * gets the single instance of the database connection
	 * if there isnt an instance, it will create a new one
	 *
	 * @author James DiNovo
	 * @date 24.10.2018
	 * @param
	 * @version 1.0
	 * @return instance
	 *
	 */
	public static Database getInstance() {
		if(instance == null) {
			instance = new Database();
		}
		return instance;
	}

	/**
	 *
	 * gets the database connection
	 *
	 * @author James DiNovo
	 * @date 24.10.2018
	 * @param
	 * @version 1.0
	 * @return connection
	 *
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 *
	 * Will create the table if it does not exist in the db
	 *
	 * @author James DiNovo
	 * @date 09.11.2018
	 * @version 1.0
	 * @param tableName is the name of the table to be created in the db
	 * @param tableQuery is the query needed to create the table in the db
	 * @param connection is the connection to the db
	 * @throws SQLException
	 */
	private void createTable(String tableName,
							String tableQuery,
							Connection connection) throws SQLException {
		Statement sqlStatement;
		//Grab the database meta data
		DatabaseMetaData md = connection.getMetaData();
		//Grab if the table exists in the database
		ResultSet result = md.getTables(null, null, tableName, null);
		//if I have a next value (the table exists, otherwise it does not)
		if(result.next()) {
			System.out.println( tableName + " Table already exists");
		}
		else {
			sqlStatement = connection.createStatement();
			sqlStatement.execute(tableQuery);
			System.out.println("The " + tableName + " table has been inserted");
		}
	}
}
