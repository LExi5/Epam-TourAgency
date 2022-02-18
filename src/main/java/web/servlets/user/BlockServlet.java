package web.servlets.user;

import DAO.factory.DAOFactory;
import DAO.sql.entity.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BlockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userID"));

        User user = new DAOFactory().getUserDAO("jdbc").getByID(userId);

        if(user.getIsBlocked() == false){
            new DAOFactory().getUserDAO("jdbc").blockUser(user.getEmail());
        }
    }
}
