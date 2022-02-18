package service;

import DAO.factory.DAOFactory;
import DAO.sql.entity.user.User;
import service.Auth.IllegalPasswordException;

public class UserService {

    public static User authentication(String email, String password) throws IllegalPasswordException {
        User user = null;
        user = new DAOFactory().getUserDAO("jdbc").getByEmail(email);
        System.out.println(user.getType());

        if (user == null) {
            return null;
        } else {
            if (user.getEmail().equals(email) && user.getUserPassword().equals(password)) {
                return user;
            } else {
                throw new IllegalPasswordException("Email or password is no correct");
            }
        }
    }

    public static boolean registration(User user){
        return false;
    }
}
