package DAO;

public class OrderSqlConst {
    public static final String UPDATE_TOUR = "UPDATE tourproject.tour_order SET tour_order.status = ? WHERE tour_order.order_id like ? AND tour_order.tour_id like ?;";
    public static final String ADD_ORDER = "INSERT INTO tourproject.tour_order VALUES (null,?,?,'Registered',?);";
    public static final String GET_ORDER = "SELECT * FROM tourproject.tour_order WHERE tour_order.tour_id = ? AND tour_order.user_id = ?";
    public static final String GET_USER_ORDER = "SELECT * FROM tourproject.tour_order WHERE tour_order.user_id = ?";
    public static final String DELETE_ORDER = "DELETE FROM tourproject.tour_order WHERE tour_order.user_id like ? AND tour_order.order_id = ?";
}
