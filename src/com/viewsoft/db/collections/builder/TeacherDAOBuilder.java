package com.viewsoft.db.collections.builder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewsoft.db.collections.TeacherDAO;
import com.viewsoft.db.collections.fragment.BloodGroup;
import com.viewsoft.db.collections.fragment.Gender;
/**
 *
 * @author noor
 */
public class TeacherDAOBuilder {    
    private TeacherDAO teacher;
    private String _id;
    private String userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private BloodGroup bloodGroup;
    
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

    public TeacherDAOBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public TeacherDAOBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public TeacherDAOBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
    
    public TeacherDAOBuilder setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }
    
    public TeacherDAO build()
    {
        teacher.set_id(_id);
        teacher.setUserId(userId);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setBloodGroup(bloodGroup);
        teacher.setGender(gender);  
        
        return teacher;
    }
    
    public TeacherDAO build(String daoContent) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            teacher = mapper.readValue(daoContent, TeacherDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return teacher;
    }
}
