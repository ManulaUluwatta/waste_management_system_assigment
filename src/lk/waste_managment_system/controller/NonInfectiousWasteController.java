package lk.waste_managment_system.controller;

import lk.waste_managment_system.db.ConnectionFactory;
import lk.waste_managment_system.model.NonInfectiousWaste;

import java.sql.*;
import java.util.ArrayList;

public class NonInfectiousWasteController {
    private Connection connection;

    public NonInfectiousWasteController() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    public boolean addNonInfectiousWaste(NonInfectiousWaste nonInfectiousWaste) throws ClassNotFoundException, SQLException {
        String sql = "insert into non_infectious_waste(typeOfWaste,object,typeOfContainer,wastePerDay) values(?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, nonInfectiousWaste.getTypeOfWaste());
        stm.setObject(2, nonInfectiousWaste.getObject());
        stm.setObject(3, nonInfectiousWaste.getTypeOfContainer());
        stm.setObject(4, nonInfectiousWaste.getWastePerDay());
        int res = stm.executeUpdate();
        if (res > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateNonInfectiousWaste(NonInfectiousWaste nonInfectiousWaste) throws ClassNotFoundException, SQLException {
        String sql = "update non_infectious_waste set typeOfWaste=?,object=?,typeOfContainer=?,wastePerDay=? where wasteID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, nonInfectiousWaste.getTypeOfWaste());
        stm.setObject(2, nonInfectiousWaste.getObject());
        stm.setObject(3, nonInfectiousWaste.getTypeOfContainer());
        stm.setObject(4, nonInfectiousWaste.getWastePerDay());
        stm.setObject(5, nonInfectiousWaste.getWasteID());
        int res = stm.executeUpdate();
        System.out.printf(res + "");
        if (res > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteNonInfectiousWaste(String id) throws ClassNotFoundException, SQLException {
        Statement stm = connection.createStatement();
        String sql = "delete from non_infectious_waste where wasteID='" + id + "' ";
        int res = stm.executeUpdate(sql);
        if (res > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<NonInfectiousWaste> view() throws ClassNotFoundException, SQLException {
        Statement stm = connection.createStatement();
        String sql = "select * from non_infectious_waste";
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<NonInfectiousWaste> infectiousWastesList = new ArrayList<>();
        while (rst.next()) {
            NonInfectiousWaste infectiousWaste = new NonInfectiousWaste(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    Integer.parseInt(rst.getString(4)),
                    Integer.parseInt(rst.getString(5))

            );
            infectiousWastesList.add(infectiousWaste);
        }
        return infectiousWastesList;
    }

    public ArrayList<NonInfectiousWaste> getID(String id) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Statement stm = connection.createStatement();
        String sql = "select * from non_infectious_waste where wasteID = '" + id + "' ";
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<NonInfectiousWaste> infectiousWastesList = new ArrayList<>();
        while (rst.next()) {
            NonInfectiousWaste infectiousWaste = new NonInfectiousWaste(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    Integer.parseInt(rst.getString(4)),
                    Integer.parseInt(rst.getString(5))
            );
            infectiousWastesList.add(infectiousWaste);
        }
        return infectiousWastesList;
    }

    public String getLastId() throws SQLException {
        String sql = "SELECT wasteID FROM non_infectious_waste ORDER BY wasteID DESC LIMIT 1";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }
}
