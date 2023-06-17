/**
 *
 */
package rw.ac.rca.webapp.dao;

import java.util.List;

import rw.ac.rca.webapp.orm.Student;

public interface StudentDAO {

    public Student saveStudent(Student student);

    public Student updateStudent(Student student);

    public Student saveOrUpdateStudent(Student student);

    public boolean deleteStudent(Student student);

    public Student getStudentById(int studentId);

    public List<Student> getAllStudents();

}
