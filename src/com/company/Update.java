package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update implements Runnable{
    @Override
    public void run() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                            "nimamonsefi","myjava123");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE documents " +
                    "SET firstname=?, lastname=?, age=?, melicode=? WHERE id=?");
            preparedStatement.setString(1,"Armin");
            preparedStatement.setString(2,"Mamali");
            preparedStatement.setLong(3,18);
            preparedStatement.setLong(4,34832);
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
