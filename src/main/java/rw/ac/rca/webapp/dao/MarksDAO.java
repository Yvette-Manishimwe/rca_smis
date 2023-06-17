package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Mark;

import java.util.List;

public interface MarksDAO {
    /**
     *
     */

    /**
     * @author Aphrodice Rwagaju
     */


    public Mark saveMarks(Mark marks);

    public Mark updateMarks(Mark marks);

        public Mark saveOrUpdateMarks(Mark marks);

        public boolean deleteMark(Mark marks);

        public Mark getMarksById(int marksId);

        public List<Mark> getAllMarks();

//        public List<User> getUserByUsername(String username);

//        public List<User> getUserByFullName(String fullName);

//        public User getUserByUserNameAndPassword(String username, String password);
//
//        public User getUserByDetails(String username, String email, String password);
//
//        public List<User> getUserByUserRoleAndApprovalStatus(UserRole userRole);

    }


