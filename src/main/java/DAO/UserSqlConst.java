package DAO;

public class UserSqlConst {
    public static final String INSERT_USER = "INSERT INTO tourproject.user VALUES(null,?,?,?,?,?,0)";
    public static final String GET_USER_EMAIL = "SELECT * FROM tourproject.user " +
            "WHERE user.email like ?";
    public static final String REMOVE_USER = "DELETE FROM tourproject.user WHERE user.email LIKE ?";
    public static final String BLOCK_USER = "UPDATE tourproject.user " +
            "SET user.isBlocked = 1 WHERE user.email like ?";
    public static final String UNBLOCK_USER = "UPDATE tourproject.user SET user.isBlocked = 0 WHERE user.email like ?";
    public static final String GET_USER_ID = "SELECT * FROM tourproject.user WHERE user.user_id like ?";
    public static final String GET_USERS = "SELECT * " +
            "FROM tourproject.user WHERE user.type_id != 3 limit ?,?";
    public static String GET_COUNT_OF_PEOPLE = "SELECT count(*) from tourproject.user Where user.type_id != 3";
    public static final String GET_USERS_COUNT = "SELECT COUNT(*) FROM tourproject.user WHERE user.type_id not like 3";
}
