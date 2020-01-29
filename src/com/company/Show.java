package com.company;

import java.sql.*;
import java.util.List;

public class Show implements Runnable{
    @Override
    public void run() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                            "nimamonsefi","myjava123");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM documents");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getLong("id"));
                System.out.println(resultSet.getString("firstname"));
                System.out.println(resultSet.getString("lastname"));
                System.out.println(resultSet.getLong("age"));
                System.out.println(resultSet.getLong("melicode"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
