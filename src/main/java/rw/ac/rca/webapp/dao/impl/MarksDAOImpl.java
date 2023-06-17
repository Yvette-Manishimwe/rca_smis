package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.MarksDAO;
import rw.ac.rca.webapp.orm.Mark;

import java.util.List;

public class MarksDAOImpl extends DAO implements MarksDAO {
    private static MarksDAOImpl instance;

    private MarksDAOImpl() {
    }

    public static MarksDAOImpl getInstance() {
        if (instance == null) {
            return new MarksDAOImpl();
        } else {
            return instance;
        }
    }
    @Override
    public Mark saveMarks(Mark marks) {
        try {
            begin();
            getSession().save(marks);
            commit();
            return marks;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Mark updateMarks(Mark marks) {
        return null;
    }

    @Override
    public Mark saveOrUpdateMarks(Mark marks) {
        return null;
    }

    @Override
    public boolean deleteMark(Mark marks) {
        return false;
    }



    @Override
    public Mark getMarksById(int marksId) {
        return null;
    }

    @Override
    public List<Mark> getAllMarks() {
        try {
            begin();
            Query query = getSession().createQuery("from Mark");
            List<Mark> marks = query.list();
            commit();
            return marks;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }
}