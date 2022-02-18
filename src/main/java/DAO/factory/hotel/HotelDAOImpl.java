package DAO.factory.hotel;

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

public class HotelDAOImpl implements HotelDAO {

    DBManager manager;
    private static final String GET_ALL_HOTELS_AND_LOCATION = "SELECT * FROM tourproject.hotel";
    private static final String GET_HOTEL = "SELECT * FROM tourproject.hotel WHERE hotel.hotel_id = ?";

    @Override
    public Hotel getHotel(int id) {
        manager = new DBManager();
        Hotel hotel = null;
        try (Connection connection = manager.getConnection();
             var statement = connection.prepareStatement(
                     GET_HOTEL)) {
            statement.setString(1,Integer.toString(id));
            var rs = statement.executeQuery();
            while (rs.next()) {
                hotel = new Hotel();
                hotel.setId(id);
                hotel.setName(rs.getString("hotel_name"));
                hotel.setRating(rs.getInt("rating"));
                hotel.setAddres(rs.getString("address"));
                hotel.setCountry(rs.getString("country"));
                hotel.setCity(rs.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;

    }

    @Override
    public List<Hotel> getHotels() {
        manager = new DBManager();
        List<Hotel> hotels = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = manager.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(GET_ALL_HOTELS_AND_LOCATION);
            rs = statement.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel();

                hotel.setId(rs.getInt("hotel_id"));
                hotel.setAddres(rs.getString("address"));
                hotel.setName(rs.getString("hotel_name"));
                hotel.setRating(rs.getDouble("rating"));
                hotel.setCountry(rs.getString("country"));
                hotel.setCity(rs.getString("city"));
                hotels.add(hotel);
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
        return hotels;
    }
}
