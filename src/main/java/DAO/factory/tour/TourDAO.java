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

    boolean increment(Tour tour);

    boolean decrement(Tour tour);

}
