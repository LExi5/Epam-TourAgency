package DAO.factory.tour;

import DAO.sql.entity.Hotel;
import DAO.sql.entity.Location;
import DAO.sql.entity.Tour;

import java.sql.SQLException;
import java.util.List;

public interface TourDAO {
    boolean add(Tour tour) throws SQLException;

    boolean remove(int id);

    Tour get(int id);

    List<Tour> getAllTours();

    boolean increment(int tourId);

    boolean decrement(int tourId);

    int getCount(int tourId);

}
