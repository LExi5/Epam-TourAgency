package web.servlets;

import DAO.factory.DAOFactory;
import DAO.factory.user.UserDAOImpl;
import DAO.sql.entity.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        User user = new User(email, password, firstname, lastname);
        System.out.println(user);
        User user2 = new DAOFactory().getUserDAO("jdbc").getByEmail(email);

        if(user.getEmail().equals(user2.getEmail())){
            req.setAttribute("massage","User is already registered");
            req.getRequestDispatcher("/registration.jsp").forward(req,resp);
        }else{
            if(new UserDAOImpl().add(user)){
                req.setAttribute("massage","User been registered");
                resp.sendRedirect(req.getContextPath()+"/login.jsp");
            }else{
                req.setAttribute("massage","Opps... try again");
                resp.sendRedirect(req.getContextPath()+"/registration.jsp");
            }
        }

    }

}
