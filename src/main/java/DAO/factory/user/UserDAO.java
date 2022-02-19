package DAO.factory.user;

import DAO.sql.entity.user.User;

import java.util.List;

public interface UserDAO {
    boolean add(User user);

    boolean remove(User user);

    User getByEmail(String email);

    User getByID(int id);

    boolean update(String email, User user);

    boolean blockUser(String email);

    boolean unBlockUser(String email);

    List<User> getUsers();

    int getUserCount();
}
