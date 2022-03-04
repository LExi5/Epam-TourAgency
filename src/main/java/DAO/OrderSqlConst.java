package DAO;

public class OrderSqlConst {
    public static final String UPDATE_TOUR = "UPDATE tourproject.tour_order SET tour_order.status = ? WHERE tour_order.user_id like ? AND tour_order.tour_id like ?;";
    public static final String ADD_ORDER = "INSERT INTO tourproject.tour_order VALUES (null,?,?,'Registered',?);";
    public static final String GET_ORDER = "SELECT * FROM tourproject.tour_order WHERE tour_order.tour_id = ? AND tour_order.user_id = ?";
    public static final String GET_USER_ORDER = "SELECT * FROM tourproject.tour_order WHERE tour_order.user_id like ? AND tour_order.tour_id like ?";
    public static final String GET_ALL_USER_ORDERS = "SELECT * FROM tourproject.tour_order WHERE tour_order.user_id = ? limit ?,?";
    public static final String GET_ALL_ORDERS = "SELECT * FROM tourproject.tour_order limit ?,?";
    public static final String GET_ALL_ORDERS_COUNT = "SELECT count(*) from tourproject.tour_order";
    public static final String GET_ALL_ORDERS_COUNT_USER = "SELECT count(*) from tourproject.tour_order where tour_order.user_id = ?";
    public static final String DELETE_ORDER = "DELETE FROM tourproject.tour_order WHERE tour_order.user_id like ? AND tour_order.order_id = ?";
}
