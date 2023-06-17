package rw.ac.rca.webapp.web;

import javax.servlet.http.HttpServlet;
import rw.ac.rca.webapp.dao.CourseDAO;
import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
import rw.ac.rca.webapp.orm.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

public class CourseReportTxt extends HttpServlet {
    public CourseReportTxt(){
        super();
    }
    CourseDAO courseDAO = CourseDAOImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String pageRedirect =  req.getParameter("page");
        if(pageRedirect.equals("coursetxt")){
            String filePath = "/Uploads";
            String fileName = "course.txt";
            String fullPath = filePath + File.separator + fileName;

            List<Course> courses = courseDAO.getAllCourses();
            if( courses != null){
                File file = new File(fullPath);
                file.getParentFile().mkdirs();
                file.createNewFile();

                try (OutputStream fos  = new FileOutputStream(file)){
                    for (Course course : courses){
                        String fullName = "Course Name: " + course.getName() + " ;";
                        String code = "Course Code: " +  course.getCode() + " ;";
                        String minStudents = "Min Students: " +  course.getMinStudent() + " ;";
                        String maxStudents = "Max Students: " +  course.getMaxStudent() + " ;";
                        String dateStart = "Date Of Start : " + course.getStart().toString() + " ;";
                        String dateStop = "Date Of End : " + course.getEnd().toString() + " ;";

                        fos.write(fullName.getBytes());
                        fos.write(code.getBytes());
                        fos.write(minStudents.getBytes());
                        fos.write(maxStudents.getBytes());
                        fos.write(dateStart.getBytes());
                        fos.write(dateStop.getBytes());

                        fos.write(System.lineSeparator().getBytes());
                    }
                }

                resp.setContentType("application/octet-stream");
                resp.setContentLength((int) file.length());
                resp.setHeader("Content-Disposition" , "attachment; filename=\"" + file.getName() + "\"");

                ServletOutputStream outputStream = resp.getOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;

                try (FileInputStream fis = new FileInputStream(file)) {
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
                outputStream.close();
                RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/courses.jsp");
                dispatcher.forward(req, resp);
            }
        }

    }
}
