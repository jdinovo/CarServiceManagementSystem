package database;

/**
 *
 * @author James DiNovo
 * @date 05.11.2018
 * @version 1.0
 *
 * DBConst contains database login information and table information
 *
 */
public class DBConst {

	private static String dbHost;
	private static String dbName;
	private static String dbUser;
	private static String dbPass;



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
