package service;

import DAO.factory.DAOFactory;
import DAO.sql.entity.user.User;

public class UserService {

    public static User authentication(String email, String password){
        User user = null;
        user = new DAOFactory().getUserDAO("jdbc").getByEmail(email);
        System.out.println(user.getType());

        if (user == null) {
            return null;
        } else {
            if (user.getEmail().equals(email) && user.getUserPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static boolean registration(User user){
        return false;
    }
}
