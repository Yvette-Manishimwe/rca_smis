package rw.ac.rca.webapp.web;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

public class StudentReportPdf extends HttpServlet {
    public StudentReportPdf(){
        super();
    }

    StudentDAO studentDAO = StudentDAOImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String pageRedirect =  req.getParameter("page");
        if(pageRedirect.equals("studenttxt")) {
            String filePath = "/Uploads";
            String fileName = "student.pdf";
            String fullPath = filePath + File.separator + fileName;

            List<Student> students = studentDAO.getAllStudents();
            if (students != null) {
                // Create the PDF document
                Document document = new Document();

                try {
                    // Create the file
                    File file = new File(fullPath);
                    file.getParentFile().mkdirs();
                    file.createNewFile();

                    // Write data to the PDF
                    PdfWriter.getInstance(document, new FileOutputStream(file));
                    document.open();
                    for (Student student : students) {
                        String fullName = "Name: " + student.getFirstName() + " " + student.getLastName() + " ;";
                        String phoneNumber = "PhoneNumber: " + student.getPhoneNumber() + " ;";
                        String dob = "Date Of Birth : " + student.getDateOfBirth().toString() + " ;";
                        // Write each row of data as a paragraph in the PDF
                        String rowData = fullName + " " + phoneNumber + " " + dob;
                        document.add(new Paragraph(rowData));
                    }
                    document.close();

                    // Set the response headers
                    resp.setContentType("application/pdf");
                    resp.setContentLength((int) file.length());
                    resp.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

                    // Write the file content to the response
                    ServletOutputStream outStream = resp.getOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    try (FileInputStream fis = new FileInputStream(file)) {
                        while ((bytesRead = fis.read(buffer)) != -1) {
                            outStream.write(buffer, 0, bytesRead);
                        }
                    }

                    outStream.close();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}