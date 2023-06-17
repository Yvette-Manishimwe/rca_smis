package rw.ac.rca.webapp.orm;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "marks")
public class Mark implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "subject")
    private String subject;

    @Column(name = "marks_obtained")
    private int marksObtained;

    // Constructors, getters, and setters

    public Mark() {
    }

    public Mark(String studentName, String subject, int marksObtained) {
        this.studentName = studentName;
        this.subject = subject;
        this.marksObtained = marksObtained;
    }

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }
}
