package Connectivity;

import java.sql.DriverManager;

public class Connection {
    public java.sql.Connection connection;
    public java.sql.Connection getConnection(){

        String dbName = "Restaurant_System";
        String username = "root";
        String password = "";

        try {
           Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }
}
