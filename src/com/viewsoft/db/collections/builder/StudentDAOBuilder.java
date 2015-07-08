package com.viewsoft.db.collections.builder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewsoft.db.collections.StudentDAO;
import com.viewsoft.db.collections.fragment.BloodGroup;
import com.viewsoft.db.collections.fragment.Gender;
/**
 *
 * @author bdit
 */
public class StudentDAOBuilder {    
    private StudentDAO student;
    private String _id;
    private String userId;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String photo;
    private String phone;
    private String email;
    private String currentAddress;
    private String permanentAddress;
    private Gender gender;
    private BloodGroup bloodGroup;
    
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

    public StudentDAOBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentDAOBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentDAOBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentDAOBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public StudentDAOBuilder setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public StudentDAOBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public StudentDAOBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentDAOBuilder setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public StudentDAOBuilder setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
        return this;
    }
    
    public StudentDAOBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
    
    public StudentDAOBuilder setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }

    public StudentDAO build()
    {
        student.set_id(_id);
        student.setUserId(userId);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setFatherName(fatherName);
        student.setMotherName(motherName);
        student.setPhoto(photo);
        student.setPhone(phone);
        student.setEmail(email);  
        student.setCurrentAddress(currentAddress);
        student.setPermanentAddress(permanentAddress);
        student.setGender(gender);
        student.setBloodGroup(bloodGroup);
        return student;
    }
    
    public StudentDAO build(String daoContent) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            student = mapper.readValue(daoContent, StudentDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return student;
    }
}
