package lk.waste_managment_system.controller;

import lk.waste_managment_system.db.ConnectionFactory;
import lk.waste_managment_system.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserController {

    public ArrayList<User> getName(String name) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Statement stm = connection.createStatement();
        String sql = "select * from login where userName='" + name + "'";
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<User> userList = new ArrayList<User>();
        while (rst.next()) {
            User u = new User(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
            userList.add(u);
        }
        return userList;
    }
}
