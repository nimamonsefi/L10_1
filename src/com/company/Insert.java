package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert implements Runnable {
    @Override
    public void run() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                            "nimamonsefi","myjava123");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO documents" +
                    "(firstname,lastname,age,melicode,id) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,"Arman");
            preparedStatement.setString(2,"Shabestari");
            preparedStatement.setLong(3,20);
            preparedStatement.setLong(4,2475);
            preparedStatement.setLong(5,1);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
