package rw.ac.rca.webapp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.util.UserRole;

/**
 * Servlet implementation class ListStudents
 */
public class ListStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudent() {
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
            if (pageRedirect.equals("students") && request.getParameter("action").equals("list")) {

                List<Student> students = studentDAO.getAllStudents();
                    System.out.println( students.size());

                httpSession.setAttribute("students", students);
                UserRole[] userRoles = UserRole.values();
                httpSession.setAttribute("userRoles", userRoles);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/students.jsp");
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