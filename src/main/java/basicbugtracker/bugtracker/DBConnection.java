package basicbugtracker.bugtracker;

import java.util.Properties;

public class DBConnection {
    private final String SERVER = "sql11.freemysqlhosting.net";
    private final int PORT = 3306;
    private final String NAME = "ql11429409";
    private final String PASSWORD = "ibwqN2jW72";

    private final String USERNAME;
    private final String PASSWORDHASH;


    public DBConnection(String username, String passwordHash) {
        this.USERNAME = username;
        this.PASSWORDHASH = passwordHash;

    }

    public boolean Connect() {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.NAME);
        connectionProps.put("password", this.PASSWORD);

        try {
            conn = DriverManager.getConnection(
                    "jdbc:" + "mysql" + "://" +
                            this.SERVER +
                            ":" + this.PORT + "/",
                    connectionProps);

            return true;
        } catch (Exception e) {
            return false;
        }


    }
}
