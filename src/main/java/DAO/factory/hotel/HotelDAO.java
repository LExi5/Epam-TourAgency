package DAO.factory.hotel;

import DAO.sql.entity.Hotel;

import java.util.List;

public interface HotelDAO {
    Hotel getHotel(int id);
    List<Hotel> getHotels();
}
