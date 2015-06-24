package com.bdit.db.collections.builder;
import com.bdit.db.collections.TeacherDAO;
/**
 *
 * @author bdit
 */
public class TeacherDAOBuilder {    
    private TeacherDAO teacher;
    private String _id;
    private String userId;
    private String designation;
    public TeacherDAOBuilder()
    {
        teacher = new TeacherDAO();
    }
    public TeacherDAOBuilder set_id(String _id) {
        this._id = _id;
        return this;
    }

    public TeacherDAOBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }
    
    public TeacherDAOBuilder setDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    public TeacherDAO build()
    {
        teacher.set_id(_id);
        teacher.setUserId(userId);
        teacher.setDesignation(designation);
        return teacher;
    }
}
