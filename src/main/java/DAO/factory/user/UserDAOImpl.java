package DAO.factory.user;

import DAO.UserSqlConst;
import DAO.sql.entity.user.Type;
import DAO.sql.entity.user.User;
import DAO.sql.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private DBManager manager;

    @Override
    public boolean add(User user) {
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(
                    UserSqlConst.INSERT_USER);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, "1");
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
    public boolean remove(User user) {
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(
                    UserSqlConst.REMOVE_USER);
            statement.setString(1, user.getEmail());
            statement.execute();
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
            return false;
        } finally {
            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
        }
        return true;
    }

    @Override
    public User getByEmail(String email) {
        User user = new User();
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(UserSqlConst.GET_USER_EMAIL);
            statement.setString(1, email);
            rs = statement.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUserPassword(rs.getString("user_password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setIsBlocked(rs.getBoolean("isBlocked"));
                int type = rs.getInt("type_id");
                if (type == 1) {
                    user.setType(Type.USER);
                } else if (type == 2) {
                    user.setType(Type.MANAGER);
                } else {
                    user.setType(Type.ADMIN);
                }
            }

        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);

            e.printStackTrace();
        } finally {
            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
        }
        return user;
    }

    @Override
    public User getByID(int id) {
        User user = new User();
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(UserSqlConst.GET_USER_ID);
            statement.setString(1, Integer.toString(id));
            rs = statement.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUserPassword(rs.getString("user_password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setIsBlocked(rs.getBoolean("isBlocked"));
                int type = rs.getInt("type_id");
                if (type == 1) {
                    user.setType(Type.USER);
                } else if (type == 2) {
                    user.setType(Type.MANAGER);
                } else {
                    user.setType(Type.ADMIN);
                }
            }


        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
        } finally {
            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
        }

        return user;
    }


    @Override
    public boolean update(String email, User user) {
        return false;
    }

    @Override
    public boolean blockUser(String email) {
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(
                    UserSqlConst.BLOCK_USER);
            statement.setString(1, email);
            statement.execute();
            return true;
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
            return false;
        } finally {
            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
        }
    }

    @Override
    public boolean unBlockUser(String email) {
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(
                    UserSqlConst.UNBLOCK_USER);
            statement.setString(1, email);
            statement.execute();

        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
            e.printStackTrace();
            return false;
        } finally {
            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
        }
        return true;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(UserSqlConst.GET_USER);
            rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUserPassword(rs.getString("user_password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setIsBlocked(rs.getBoolean("isBlocked"));
                int type = rs.getInt("type_id");
                if (type == 1) {
                    user.setType(Type.USER);
                } else if (type == 2) {
                    user.setType(Type.MANAGER);
                } else {
                    user.setType(Type.ADMIN);
                }
                users.add(user);
            }
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);

            e.printStackTrace();
        } finally {
            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
        }
        return users;
    }

    @Override
    public int getUserCount() {
        int count = 0;
        manager = new DBManager();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = manager.getConnection();
            statement = connection.prepareStatement(UserSqlConst.GET_USER);
            rs = statement.executeQuery();
            while (rs.next()) {
                count = rs.getInt("");
            }
        } catch (SQLException e) {
            DBManager.getInstance().rollback(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);

            e.printStackTrace();
        } finally {
            DBManager.getInstance().commit(connection);
            DBManager.getInstance().close(rs);
            DBManager.getInstance().close(statement);
            DBManager.getInstance().close(connection);
        }
        return count;
    }
}
