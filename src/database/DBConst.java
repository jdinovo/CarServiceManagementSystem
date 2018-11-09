package database;

/**
 *
 * DBConst contains database login information and table information
 *
 * @author James DiNovo
 * @date 05.11.2018
 * @version 1.0
 *
 */
public class DBConst {

	private static String dbHost;
	private static String dbName;
	private static String dbUser;
	private static String dbPass;

	//Create a constant for each of the table and column names
	public static final String TABLE_CUSTOMERS = "customers";
	public static final String CUSTOMER_COLUMN_ID = "id";
	public static final String CUSTOMER_COLUMN_FNAME = "first_name";
	public static final String CUSTOMER_COLUMN_LNAME = "last_name";
	public static final String CUSTOMER_COLUMN_ADDR = "address";
	public static final String CUSTOMER_COLUMN_CITY = "city";
	public static final String CUSTOMER_COLUMN_POSTAL = "postal_code";
	public static final String CUSTOMER_COLUMN_PHONE = "phone_number";
	public static final String CUSTOMER_COLUMN_EMAIL = "email";
	public static final String CUSTOMER_COLUMN_VEHICLES = "vehicles";

	public static final String TABLE_VEHICLES = "vehicles";
	public static final String VEHICLE_COLUMN_ID = "id";
	public static final String VEHICLE_COLUMN_VIN = "vin";
	public static final String VEHICLE_COLUMN_BRAND = "brand";
	public static final String VEHICLE_COLUMN_MODEL = "model";
	public static final String VEHICLE_COLUMN_YEAR = "year";
	public static final String VEHICLE_COLUMN_KM = "kilometers";
	public static final String VEHICLE_COLUMN_WORKORDERS = "work_orders";

	public static final String TABLE_WORKORDERS = "work_orders";
	public static final String WORKORDERS_COLUMN_ID = "id";
	public static final String WORKORDERS_COLUMN_DATE = "date";
	public static final String WORKORDERS_COLUMN_ISSUE = "issue";
	public static final String WORKORDERS_COLUMN_CAUSE = "cause";
	public static final String WORKORDERS_COLUMN_CORRECTION = "correction";

	//Create the database tables
	public static final String CREATE_TABLE_CUSTOMERS =
			"CREATE TABLE " + TABLE_CUSTOMERS + " (" +
					CUSTOMER_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
					CUSTOMER_COLUMN_FNAME + " VARCHAR(50), " +
					CUSTOMER_COLUMN_LNAME + " VARCHAR(50), " +
					CUSTOMER_COLUMN_ADDR + " VARCHAR(100), " +
					CUSTOMER_COLUMN_CITY + " VARCHAR(50), " +
					CUSTOMER_COLUMN_POSTAL + " CHAR(6), " +
					CUSTOMER_COLUMN_PHONE + " VARCHAR(15), " +
					CUSTOMER_COLUMN_EMAIL + " VARCHAR(50), " +
					CUSTOMER_COLUMN_VEHICLES + " int REFERENCES " +
					TABLE_VEHICLES + "(" + VEHICLE_COLUMN_ID + ")," +
					"PRIMARY KEY(" + CUSTOMER_COLUMN_ID + ")" +
					");";

	public static final String CREATE_TABLE_VEHICLES =
			"CREATE TABLE " + TABLE_VEHICLES + " (" +
					VEHICLE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
					VEHICLE_COLUMN_VIN + " CHAR(17) NOT NULL, " +
					VEHICLE_COLUMN_BRAND + " VARCHAR(25), " +
					VEHICLE_COLUMN_MODEL + " VARCHAR(50), " +
					VEHICLE_COLUMN_YEAR + " CHAR(4), " +
					VEHICLE_COLUMN_KM + " int, " +
					VEHICLE_COLUMN_WORKORDERS + " int REFERENCES " +
					TABLE_WORKORDERS + "(" + WORKORDERS_COLUMN_ID + ")," +
					"PRIMARY KEY(" + VEHICLE_COLUMN_ID +")" +
					");";

	public static final String CREATE_TABLE_WORKORDERS =
			"CREATE TABLE " + TABLE_WORKORDERS + " (" +
					WORKORDERS_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
					WORKORDERS_COLUMN_DATE + " DATE, " +
					WORKORDERS_COLUMN_ISSUE + " VARCHAR(255), " +
					WORKORDERS_COLUMN_CAUSE + " VARCHAR(255), " +
					WORKORDERS_COLUMN_CORRECTION + " VARCHAR(255), " +
					"PRIMARY KEY(" + WORKORDERS_COLUMN_ID +")" +
					");";

	/**
	 * @author James DiNovo
	 * @date 05.11.2018
	 * @version 1.0
	 * @return String
	 */
	public static String getDbName() {
		return dbName;
	}

	/**
	 * @author James DiNovo
	 * @date 05.11.2018
	 * @version 1.0
	 * @param dbName
	 */
	public static void setDbName(String dbName) {
		DBConst.dbName = dbName;
	}

	/**
	 * @author James DiNovo
	 * @date 05.11.2018
	 * @version 1.0
	 * @return String
	 */
	public static String getDbUser() {
		return dbUser;
	}

	/**
	 * @author James DiNovo
	 * @date 05.11.2018
	 * @version 1.0
	 * @param dbUser
	 */
	public static void setDbUser(String dbUser) {
		DBConst.dbUser = dbUser;
	}

	/**
	 * @author James DiNovo
	 * @date 05.11.2018
	 * @version 1.0
	 * @return String
	 */
	public static String getDbPass() {
		return dbPass;
	}

	/**
	 * @author James DiNovo
	 * @date 05.11.2018
	 * @version 1.0
	 * @param dbPass
	 */
	public static void setDbPass(String dbPass) {
		DBConst.dbPass = dbPass;
	}

	/**
	 * @author James DiNovo
	 * @date 05.11.2018
	 * @version 1.0
	 * @return String
	 */
	public static String getDbHost() {
		return dbHost;
	}

	/**
	 * @author James DiNovo
	 * @date 05.11.2018
	 * @version 1.0
	 * @param dbHost
	 */
	public static void setDbHost(String dbHost) {
		DBConst.dbHost = dbHost;
	}
}
