package rw.ac.rca.webapp.web;


import org.springframework.expression.ParseException;
import rw.ac.rca.webapp.dao.MarksDAO;
import rw.ac.rca.webapp.dao.impl.MarksDAOImpl;
import rw.ac.rca.webapp.orm.Mark;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateCourse
 */
public class CreateMarks extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MarksDAO marksDAO = MarksDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMarks() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);

        if (pageRedirect != null) {
            System.out.println("The print statement is and the only is: " + pageRedirect);
            if (pageRedirect.equals("createmarks")) {
                request.getRequestDispatcher("WEB-INF/createmarks.jsp").forward(request, response);
            } else {
                request.setAttribute("error ", "No user found");
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error ", "No user found");
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");

        if(pageRedirect != null){
            if(pageRedirect.equals("createmarks")){
                Mark marks = null;
                try {
                    marks = new Mark(
                            request.getParameter("studentname"),
                            request.getParameter("subject"),
                            Integer.parseInt(request.getParameter("marksobtained"))
                    );
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                // Saving the course;
                try {
                    marksDAO.saveMarks(marks);
                    request.setAttribute("success" , "Successfully marks added" );
                    request.getRequestDispatcher("WEB-INF/createmarks.jsp").forward(request , response);
                }catch (Exception e){
                    request.setAttribute("error" , "Failed to add new marks" );
                    request.getRequestDispatcher("WEB-INF/createmarks.jsp").forward(request , response);
                }
            }else{
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
            }
        }else{
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
        }
    }

}