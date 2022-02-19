package web.filters;

import DAO.sql.entity.user.Type;
import DAO.sql.entity.user.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;

public class IsLoginFilter implements Filter {
    private ServletContext context;

    private Map<Type, List<String>> accessPages;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        List<String> userPages = asList(filterConfig.getInitParameter("user-param").split(" "));
        List<String> managerPages = asList(filterConfig.getInitParameter("manager-param").split(" "));
        List<String> adminPages = asList(filterConfig.getInitParameter("admin-param").split(" "));

        accessPages = new TreeMap<Type, List<String>>();
        accessPages.put(Type.USER, userPages);
        accessPages.put(Type.MANAGER, managerPages);
        accessPages.put(Type.ADMIN, adminPages);

        System.out.println(accessPages);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String[] uri = req.getRequestURI().split("/");
        String url = uri[uri.length - 1];

        Type type = (Type) session.getAttribute("access");
        System.out.println(url);

        if ( accessPages.get(Type.ADMIN).contains(url) && type != Type.ADMIN) {
            req.setAttribute("massage", "Firstly you should login");
            req.getRequestDispatcher("/error.jsp").forward(servletRequest, servletResponse);
        } else if (accessPages.get(Type.MANAGER).contains(url) && type != Type.MANAGER && type != Type.ADMIN) {
            req.setAttribute("massage", "Firstly you should login");
            req.getRequestDispatcher("/error.jsp").forward(servletRequest, servletResponse);
        } else if (accessPages.get(Type.USER).contains(url) && type != Type.USER && type != Type.ADMIN && type != Type.MANAGER) {
            req.setAttribute("massage", "Firstly you should login");
            req.getRequestDispatcher("/error.jsp").forward(servletRequest, servletResponse);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
