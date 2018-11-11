package database;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

/**
 *
 * Login class loads and saves DB credentials to and from a file
 *
 * @author James DiNovo
 * @date 05.11.2018
 * @version 1.0
 *
 */

public class Login {

    /**
     * Login Constructor.
     *
     * @author James DiNovo
     * @date 06.11.2018
     * @version 1.0
     */
    public Login() {
        if (load()) {
            System.out.println("LOADED");
        }
    }

    /**
     * loads login credentials from file
     *
     * @return boolean returns false if no file found or credentials are not readable
     * @author James DiNovo
     * @date 06.11.2018
     * @version 1.0
     */
    public boolean load() {
        File file = new File("Login.dat");
        HashMap<String, String> login;

        if (!file.exists()) {
            return false;
        } else {
            try {
                //read in object from file
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                HashMap<String, String> readIn = (HashMap<String, String>) in.readObject();

                if (!readIn.isEmpty()) {
                    login = readIn;
                    if (test(login.get("DB_HOST"), login.get("DB_NAME"), login.get("DB_USER"), login.get("DB_PASS"))) {
                        DBConst.setDbHost(login.get("DB_HOST"));
                        DBConst.setDbName(login.get("DB_NAME"));
                        DBConst.setDbUser(login.get("DB_USER"));
                        DBConst.setDbPass(login.get("DB_PASS"));
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

                in.close();

            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }


    /**
     * saves login credentials to a file
     *
     * @author James DiNovo
     * @date 06.11.2018
     * @version 1.0
     */
    public void save() {
        File file = new File("Login.dat");
        HashMap<String, String> login = new HashMap<>();
        login.put("DB_HOST", DBConst.getDbHost());
        login.put("DB_NAME", DBConst.getDbName());
        login.put("DB_USER", DBConst.getDbUser());
        login.put("DB_PASS", DBConst.getDbPass());

        if (file.exists()) {
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
     * tests login credentials
     *
     * @param dbHost database host
     * @param dbName database name
     * @param dbUser username
     * @param dbPass password
     * @return boolean true if valid credentials, false if not
     * @author James DiNovo
     * @date 06.11.2018
     * @version 1.0
     */
    public boolean test(String dbHost, String dbName, String dbUser, String dbPass) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + "/" + dbName + "?useSSL=false", dbUser, dbPass);
            connection.close();
            connection = null;
            return true;
        } catch (Exception e1) {
            return false;
        }

    }
}

