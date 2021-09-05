package lk.waste_managment_system.controller;

import lk.waste_managment_system.db.ConnectionFactory;
import lk.waste_managment_system.model.InfectiousWaste;

import java.sql.*;
import java.util.ArrayList;

public class InfectiousWasteController {
    private Connection connection;

    public InfectiousWasteController() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    public boolean addInfectiousWaste(InfectiousWaste infectiousWaste) throws ClassNotFoundException, SQLException {
        String sql = "insert into infectious_waste(typeOfWaste,object,typeOfContainer,wastePerDay) values(?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, infectiousWaste.getTypeOfWaste());
        stm.setObject(2, infectiousWaste.getObject());
        stm.setObject(3, infectiousWaste.getTypeOfContainer());
        stm.setObject(4, infectiousWaste.getWastePerDay());
        int res = stm.executeUpdate();
        if (res > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateInfectiousWaste(InfectiousWaste infectiousWaste) throws ClassNotFoundException, SQLException {
        String sql = "update infectious_waste set typeOfWaste=?,object=?,typeOfContainer=?,wastePerDay=? where wasteID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, infectiousWaste.getTypeOfWaste());
        stm.setObject(2, infectiousWaste.getObject());
        stm.setObject(3, infectiousWaste.getTypeOfContainer());
        stm.setObject(4, infectiousWaste.getWastePerDay());
        stm.setObject(5, infectiousWaste.getWasteID());
        int res = stm.executeUpdate();
        System.out.printf(res + "");
        if (res > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteInfectiousWaste(String id) throws ClassNotFoundException, SQLException {
        Statement stm = connection.createStatement();
        String sql = "delete from infectious_waste where wasteID='" + id + "' ";
        int res = stm.executeUpdate(sql);
        if (res > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<InfectiousWaste> view() throws ClassNotFoundException, SQLException {
        Statement stm = connection.createStatement();
        String sql = "select * from infectious_waste";
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<InfectiousWaste> infectiousWastesList = new ArrayList<>();
        while (rst.next()) {
            InfectiousWaste infectiousWaste = new InfectiousWaste(
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

    public ArrayList<InfectiousWaste> getID(String id) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Statement stm = connection.createStatement();
        String sql = "select * from infectious_waste where wasteID = '" + id + "' ";
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<InfectiousWaste> infectiousWastesList = new ArrayList<>();
        while (rst.next()) {
            InfectiousWaste infectiousWaste = new InfectiousWaste(
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
        String sql = "SELECT wasteID FROM infectious_waste ORDER BY wasteID DESC LIMIT 1";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }
}
