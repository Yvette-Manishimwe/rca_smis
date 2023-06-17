package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.ParentDAO;
import rw.ac.rca.webapp.dao.impl.ParentDAOImpl;
import rw.ac.rca.webapp.orm.Parent;
import rw.ac.rca.webapp.util.UserRole;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListParent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ParentDAO parentDAO = ParentDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListParent() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");

        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);

        if (pageRedirect != null) {
            if (pageRedirect.equals("parents") && request.getParameter("action").equals("list")) {

                List<Parent> parents = parentDAO.getAllParents();
                System.out.println(parents.size());
                httpSession.setAttribute("parents", parents);
                UserRole[] userRoles = UserRole.values();
                httpSession.setAttribute("userRoles", userRoles);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/parents.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            httpSession.setAttribute("error", "Invalid User. Try again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
