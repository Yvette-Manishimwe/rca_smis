package rw.ac.rca.webapp.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Address;
import rw.ac.rca.webapp.orm.Student;

/**
 * Servlet implementation class CreateStudent
 */
public class CreateStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");

        if (pageRedirect != null && pageRedirect.equals("createstudent")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String dateOfBirthString = request.getParameter("dateOfBirth");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String phoneNumber = request.getParameter("phoneNumber");
            int stdaddress = Integer.parseInt(request.getParameter("address"));

            Address address = new Address(stdaddress);
            try {
                Date dateOfBirth = dateFormat.parse(dateOfBirthString);

                Student student = new Student(firstName, lastName, dateOfBirth, email, gender, phoneNumber,address, false, false, false);
                studentDAO.saveOrUpdateStudent(student);

                request.setAttribute("success", "Successfully created the student");
                request.getRequestDispatcher("WEB-INF/createstudent.jsp").forward(request, response);
            } catch (ParseException e) {
                e.printStackTrace();
                request.setAttribute("error", "Invalid date format");
                request.getRequestDispatcher("WEB-INF/createstudent.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Failed to create the student");
                request.getRequestDispatcher("WEB-INF/createstudent.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageRedirect = req.getParameter("page");

        HttpSession httpSession = req.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);

        if (pageRedirect != null && pageRedirect.equals("createstudent")) {
            req.getRequestDispatcher("WEB-INF/createstudent.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "No user found");
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
        }
    }
}
