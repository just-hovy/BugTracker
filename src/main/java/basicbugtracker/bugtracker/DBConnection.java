package basicbugtracker.bugtracker;

import java.sql.*;
import java.util.Properties;


public class DBConnection {
    private final String SERVER = "";
    private final int PORT = 3306;
    private final String NAME = "";
    private final String PASSWORD = "";

    private Connection conn = null;

    public DBConnection() {
        Connect();
    }

    public boolean Connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.NAME);
        connectionProps.put("password", this.PASSWORD);

        try {
            conn = DriverManager.getConnection(
                    "jdbc:" + "mysql" + "://" +
                            this.SERVER +
                            ":" + this.PORT + "/sql11429409",
                    connectionProps);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public ResultSet sqlQuery(String sql) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            st.close();
            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
