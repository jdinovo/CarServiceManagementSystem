package database;

import java.io.*;
import java.util.HashMap;

/**
 *
 * @author James DiNovo
 * @date 05.11.2018
 * @version 1.0
 *
 * DBConst contains database login information
 *
 */
public class DBConst {

	private static String dbName;
	private static String dbUser;
	private static String dbPass;

	/**
	 *
	 * @author James DiNovo
	 * @date 05.11.2018
	 * @version 1.0
	 * @return boolean returns false if no file found or credentials are not readable
	 *
	 * loads log in credentials from file
	 *
	 */
	public static boolean loginLoad() {
		File file = new File("Login.dat");
		HashMap<String, String> login;

		if(!file.exists()) {
			return false;
		} else {
			try {

				//read in object from file
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
				HashMap<String, String> readIn = (HashMap<String, String>) in.readObject();

				if(!readIn.isEmpty()) {
					login = readIn;
					dbName = login.get("DB_NAME");
					dbUser = login.get("DB_USER");
					dbPass = login.get("DB_PASS");
//					try {
//						Database db = Database.getInstance();
//					} catch (Exception e) {
//						e.printStackTrace();
//						return false;
//					}
				} else {
					return false;
				}

				in.close();

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		return true;
	}

	/**
	 *
	 * @author James DiNovo
	 * @date 05.11.2018
	 * @version 1.0
	 *
	 * saves login credentials to a file
	 *
	 */
	public static void loginSave() {
		File file = new File("Login.dat");
		HashMap<String, String> login = new HashMap<>();
		login.put("DB_NAME", dbName);
		login.put("DB_USER", dbUser);
		login.put("DB_PASS", dbPass);

		if(file.exists()) {
			file.delete();
		}

		try {
			file.createNewFile();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

			out.writeObject(login);
			out.flush();
			out.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

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
}
