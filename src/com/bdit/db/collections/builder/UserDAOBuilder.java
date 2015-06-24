package com.bdit.db.collections.builder;
import com.bdit.db.collections.UserDAO;
/**
 *
 * @author bdit
 */
public class UserDAOBuilder {    
    private UserDAO user;
    private String _id;
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
    public UserDAOBuilder()
    {
        user = new UserDAO();
    }
    public UserDAOBuilder set_id(String _id) {
        this._id = _id;
        return this;
    }
    public UserDAOBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public UserDAOBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public UserDAOBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }
    public UserDAOBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }
    public UserDAOBuilder setPhoto(String photo) {
        this.photo = photo;
        return this;
    }
    public UserDAOBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }
    public UserDAOBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    public UserDAOBuilder setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }
    public UserDAOBuilder setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }
    public UserDAOBuilder setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
        return this;
    }
    
    public UserDAO build()
    {
        user.set_id(_id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setFatherName(fatherName);
        user.setMotherName(motherName);
        user.setPhoto(photo);
        user.setPhone(phone);
        user.setEmail(email);
        user.setBloodGroup(bloodGroup);
        user.setCurrentAddress(currentAddress);
        user.setPermanentAddress(permanentAddress);
        return user;
    }
}
