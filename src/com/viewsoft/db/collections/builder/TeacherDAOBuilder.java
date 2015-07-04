package com.viewsoft.db.collections.builder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewsoft.db.collections.TeacherDAO;
/**
 *
 * @author bdit
 */
public class TeacherDAOBuilder {    
    private TeacherDAO teacher;
    private String _id;
    private String userId;
    private String designation;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String photo;
    private String phone;
    private String email;
    private String bloodGroup;
    private String currentAddress;
    private String permanentAddress;
    
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

    public TeacherDAOBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public TeacherDAOBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public TeacherDAOBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public TeacherDAOBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public TeacherDAOBuilder setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public TeacherDAOBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public TeacherDAOBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public TeacherDAOBuilder setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }

    public TeacherDAOBuilder setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public TeacherDAOBuilder setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
        return this;
    }
    
    

    public TeacherDAO build()
    {
        teacher.set_id(_id);
        teacher.setUserId(userId);
        teacher.setDesignation(designation);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setFatherName(fatherName);
        teacher.setMotherName(motherName);
        teacher.setPhoto(photo);
        teacher.setPhone(phone);
        teacher.setEmail(email);
        teacher.setBloodGroup(bloodGroup);
        teacher.setCurrentAddress(currentAddress);
        teacher.setPermanentAddress(permanentAddress);
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
