package rw.ac.rca.webapp.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.orm.User;

/**
 * implements student interface extends DAO
 *
 * @see StudentDAO
 * @see DAO
 * @author Aphrodice Rwagaju
 *
 */
public class StudentDAOImpl extends DAO implements StudentDAO {
    public static final Logger LOG = Logger.getLogger(StudentDAOImpl.class);
    public static StudentDAOImpl instance;

    /**
     * @return student instance
     */
    public static StudentDAOImpl getInstance() {
        if (instance == null) {
            return new StudentDAOImpl();

        } else {
            return instance;
        }
    }

    private StudentDAOImpl() {
    }

    /**
     * saves student
     *
     * @return student
     * @throws Exception
     */
    @Override
    public Student saveStudent(Student student) {
        try {
            begin();
            Student std = (Student) getSession().save(student);
            commit();
            return std;

        } catch (Exception e) {
            rollback();
            return null;
        }


    }

    /**
     * updates student
     *
     * @return student
     * @throws Exception
     */
    @Override
    public Student updateStudent(Student student) {
        try {
            begin();
            getSession().update(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    /**
     * saves or updates student
     *
     * @return student
     * @throws Exception
     */
    @Override
    public Student saveOrUpdateStudent(Student student) {
        try {
            begin();
            getSession().saveOrUpdate(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }

    }

    /**
     * deletes student
     *
     * @return true
     * @return false
     * @throws Exception
     */
    @Override
    public boolean deleteStudent(Student student) {
        try {
            begin();
            getSession().delete(student);
            commit();
            return true;
        } catch (Exception e) {
            rollback();
            return false;
        }
    }

    /**
     * gets student by id
     *
     * @return student
     * @throws Exception
     */
    @Override
    public Student getStudentById(int id) {
        try {
            begin();
            Query query = getSession().createQuery("from Student where id= :ref");
            query.setInteger("ref", id);
            Student student = (Student) query.uniqueResult();
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    /**
     * gets all students
     *
     * @return list students
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAllStudents() {
        try {
            begin();
            Query query = getSession().createQuery("FROM Student");
            List<Student> students = query.list();
            commit();
            return students;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }


}