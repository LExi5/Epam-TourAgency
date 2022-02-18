package DAO.factory.order;

import DAO.OrderSqlConst;
import DAO.factory.DAOFactory;
import DAO.sql.DBManager;
import DAO.sql.entity.Status;
import DAO.sql.entity.TourOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DAO.sql.entity.Status.*;
import static javax.print.attribute.standard.JobState.CANCELED;

public class OrderDAOImpl implements OrderDAO {
    private DBManager manager;

    @Override
    public TourOrder getOrder(int userId, int tourId) {
        TourOrder order = null;
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(
                    OrderSqlConst.GET_ORDER);
            statement.setString(1, Integer.toString(tourId));
            statement.setString(2, Integer.toString(userId));
             rs = statement.executeQuery();
            while (rs.next()) {
                order = new TourOrder();
                order.setId(rs.getInt("oreder_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTourId(rs.getInt("tour_id"));
                String status = rs.getString("status");
                if(status.equals("Registered")){
                    order.setStatus(REGISTERED);
                }else if(status.equals("Payed")){
                    order.setStatus(PAYED);
                }else{
                    order.setStatus(CANCELLED);
                }
                order.setRegistrationDate(rs.getDate("registration_date"));
                order.setTour(new DAOFactory().getTourDAO("jdbc").get(order.getTourId()));

            }
            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public TourOrder getUserOrder(int userId) {
        TourOrder order = null;
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(
                    OrderSqlConst.GET_USER_ORDER);
            statement.setString(1, Integer.toString(userId));
            rs = statement.executeQuery();
            while (rs.next()) {
                order = new TourOrder();
                order.setId(rs.getInt("oreder_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTourId(rs.getInt("tour_id"));
                String status = rs.getString("status");
                if(status.equals("Registered")){
                    order.setStatus(REGISTERED);
                }else if(status.equals("Payed")){
                    order.setStatus(PAYED);
                }else{
                    order.setStatus(CANCELLED);
                }
                order.setRegistrationDate(rs.getDate("registration_date"));
                order.setTour(new DAOFactory().getTourDAO("jdbc").get(order.getTourId()));

            }
            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean addOrder(TourOrder order) {
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(
                    OrderSqlConst.ADD_ORDER);
            statement.setString(1, Integer.toString(order.getUserId()));
            statement.setString(2, Integer.toString(order.getTourId()));
            statement.setString(3, new Date(System.currentTimeMillis()).toString());
            statement.execute();

            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            return true;
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean changeStatus(TourOrder order) {
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(
                    OrderSqlConst.UPDATE_TOUR);
            statement.setString(1, REGISTERED.getText());
            statement.setString(2, Integer.toString(order.getUserId()));
            statement.setString(3, Integer.toString(order.getTourId()));
            statement.execute();

            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            return true;
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteOrder(TourOrder order) {
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(
                    OrderSqlConst.DELETE_ORDER);
            statement.setString(1, Integer.toString(order.getUserId()));
            statement.setString(2, Integer.toString(order.getTourId()));
            statement.execute();

            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            return true;
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<TourOrder> getAllUserOrders(int userId) {
        List<TourOrder> orders = new ArrayList<>();
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(
                    OrderSqlConst.GET_USER_ORDER);
            statement.setString(1, Integer.toString(userId));
            rs = statement.executeQuery();
            while (rs.next()) {
                TourOrder order = new TourOrder();
                order = new TourOrder();
                order.setId(rs.getInt("oreder_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTourId(rs.getInt("tour_id"));
                String status = rs.getString("status");
                if(status.equals("Registered")){
                    order.setStatus(REGISTERED);
                }else if(status.equals("Payed")){
                    order.setStatus(PAYED);
                }else{
                    order.setStatus(CANCELLED);
                }
                order.setRegistrationDate(rs.getDate("registration_date"));
                order.setTour(new DAOFactory().getTourDAO("jdbc").get(order.getTourId()));
                orders.add(order);
            }
            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
        }
        return orders;
    }
}
