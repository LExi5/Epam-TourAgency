package DAO;

public class TourSqlConst {
    public static final String GET_ALL_TOURS = "SELECT * FROM tourproject.tour INNER JOIN tourproject.hotel on hotel.hotel_id = tour.hotel_id " +
            "ORDER BY tour.status limit ?,?";
    public static final String ADD_TOUR = "INSERT INTO tourproject.tour VALUE (null,?,?,?,?,?,?,?,?,?,?,?,?);";
    public static final String REMOVE_TOUR = "DELETE FROM tourproject.tour WHERE tour.tour_id like ?";
    public static final String GET_TOUR = "SELECT * FROM tourproject.tour INNER JOIN tourproject.hotel on hotel.hotel_id = tour.hotel_id WHERE tour.tour_id like ?";
    public static final String GET_COUNT_OF_TOURS = "SELECT count(*) FROM tourproject.tour ";
    public static final String GET_COUNT_OF_PEOPLE = "SELECT tour.count_people FROM tourproject.tour WHERE tour.tour_id like ?";
    public static final String SET_COUNT_OF_PEOPLE = "UPDATE tourproject.tour SET tour.count_people = ? WHERE tour.tour_id = ?";
    public static final String SET_STATUS = "UPDATE tourproject.tour SET tour.status = ? WHERE tour.tour_id = ?";
}
