package DAO.factory.tour;

import DAO.TourSqlConst;
import DAO.sql.DBManager;
import DAO.sql.entity.Hotel;
import DAO.sql.entity.Location;
import DAO.sql.entity.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourDAOImpl implements TourDAO {

    DBManager manager;

    @Override
    public boolean add(Tour tour) throws SQLException {
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = manager.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(
                    TourSqlConst.ADD_TOUR);
            statement.setString(1, Integer.toString(tour.getLasting()));
            statement.setString(2, Integer.toString(tour.getCountPeople()));
            statement.setString(3, Integer.toString(tour.getHotel().getId()));
            statement.setString(4, tour.getStartDate().toString());
            statement.setString(5, tour.getEndDate().toString());
            statement.setString(6, tour.getStatus());
            statement.setString(7, tour.getDescription());
            statement.setString(8, Integer.toString(tour.getPrice()));
            statement.setString(9, tour.getType());
            statement.setString(10, Integer.toString(tour.getDiscount()));
            statement.setString(11, Integer.toString(tour.getStep()));
            statement.setString(12, tour.getName());
            statement.execute();

            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);

        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = manager.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(TourSqlConst.REMOVE_TOUR);
            statement.setString(1, Integer.toString(id));
            statement.execute();

            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            return true;
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(connection);
            DBManager.getInstance().close(statement);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Tour get(int id) {
        Tour tour = new Tour();
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = manager.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(TourSqlConst.GET_TOUR);
            statement.setString(1, Integer.toString(id));
            rs = statement.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel();
                tour.setId(rs.getInt("tour_id"));
                tour.setName(rs.getString("tour_name"));
                tour.setLasting(rs.getInt("lasting"));
                tour.setCountPeople(rs.getInt("count_people"));
                tour.setStartDate(rs.getDate("tour_date_start"));
                tour.setEndDate(rs.getDate("tour_date_end"));
                tour.setDescription(rs.getString("tour_description"));
                tour.setPrice(rs.getInt("price"));
                tour.setDiscount(rs.getInt("discount"));
                tour.setStep(rs.getInt("step"));
                tour.setStatus(rs.getString("status"));
                tour.setType(rs.getString("type"));

                hotel.setId(rs.getInt("hotel_id"));
                hotel.setAddres(rs.getString("address"));
                hotel.setName(rs.getString("hotel_name"));
                hotel.setRating(rs.getDouble("rating"));
                hotel.setCountry(rs.getString("country"));
                hotel.setCity(rs.getString("city"));

                tour.setHotel(hotel);
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
        return tour;
    }

    @Override
    public List<Tour> getAllTours() {
        List<Tour> tours = new ArrayList<>();
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(TourSqlConst.GET_ALL_TOURS);
            rs = statement.executeQuery();
            while (rs.next()) {
                Tour tour = new Tour();
                Hotel hotel = new Hotel();
                tour.setId(rs.getInt("tour_id"));
                tour.setName(rs.getString("tour_name"));
                tour.setLasting(rs.getInt("lasting"));
                tour.setCountPeople(rs.getInt("count_people"));
                tour.setStartDate(rs.getDate("tour_date_start"));
                tour.setEndDate(rs.getDate("tour_date_end"));
                tour.setDescription(rs.getString("tour_description"));
                tour.setPrice(rs.getInt("price"));
                tour.setDiscount(rs.getInt("discount"));
                tour.setStep(rs.getInt("step"));
                tour.setStatus(rs.getString("status"));

                hotel.setId(rs.getInt("hotel_id"));
                hotel.setAddres(rs.getString("address"));
                hotel.setName(rs.getString("hotel_name"));
                hotel.setRating(rs.getDouble("rating"));
                hotel.setCountry(rs.getString("country"));
                hotel.setCity(rs.getString("city"));

                tour.setHotel(hotel);
                tours.add(tour);

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
        return tours;
    }

    public  boolean increment(Tour tour){
        return false;
    }
    public  boolean decrement(Tour tour){
        return false;
    }
}
