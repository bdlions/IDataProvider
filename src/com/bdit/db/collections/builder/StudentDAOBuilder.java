package com.bdit.db.collections.builder;
import com.bdit.db.collections.StudentDAO;
/**
 *
 * @author bdit
 */
public class StudentDAOBuilder {    
    private StudentDAO student;
    private String _id;
    private String userId;
    public StudentDAOBuilder()
    {
        student = new StudentDAO();
    }
    public StudentDAOBuilder set_id(String _id) {
        this._id = _id;
        return this;
    }

    public StudentDAOBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public StudentDAO build()
    {
        student.set_id(_id);
        student.setUserId(userId);
        return student;
    }
}
