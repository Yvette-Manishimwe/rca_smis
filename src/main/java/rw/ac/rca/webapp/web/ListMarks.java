package rw.ac.rca.webapp.web;


import rw.ac.rca.webapp.dao.MarksDAO;
import rw.ac.rca.webapp.dao.impl.MarksDAOImpl;
import rw.ac.rca.webapp.orm.Mark;
import rw.ac.rca.webapp.util.UserRole;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListMarks extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MarksDAO marksDAO = MarksDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMarks() {
        super();
        // TODO Auto-generated constructor stub
    }

    //    /**
//     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String pageRedirect = request.getParameter("page");

        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);

        if (pageRedirect != null) {
            if (pageRedirect.equals("marks") && request.getParameter("action").equals("list")) {

                List<Mark> marks = marksDAO.getAllMarks();
                httpSession.setAttribute("marks", marks);
                UserRole[] userRoles = UserRole.values();
                httpSession.setAttribute("userRoles", userRoles);
                request.getRequestDispatcher("WEB-INF/marks.jsp").forward(request, response);
            }
        } else {
            httpSession.setAttribute("error", "Invalid User. Try again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
