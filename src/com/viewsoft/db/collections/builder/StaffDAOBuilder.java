package com.viewsoft.db.collections.builder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewsoft.db.collections.StaffDAO;
import com.viewsoft.db.collections.fragment.BloodGroup;
import com.viewsoft.db.collections.fragment.Gender;
/**
 *
 * @author noor
 */
public class StaffDAOBuilder {    
    private StaffDAO staff;
    private String _id;
    private String userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private BloodGroup bloodGroup;
    
    public StaffDAOBuilder()
    {
        staff = new StaffDAO();
    }
    public StaffDAOBuilder set_id(String _id) {
        this._id = _id;
        return this;
    }

    public StaffDAOBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public StaffDAOBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StaffDAOBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public StaffDAOBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
    
    public StaffDAOBuilder setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }
    
    public StaffDAO build()
    {
        staff.set_id(_id);
        staff.setUserId(userId);
        staff.setFirstName(firstName);
        staff.setLastName(lastName);
        staff.setBloodGroup(bloodGroup);
        staff.setGender(gender);  
        
        return staff;
    }
    
    public StaffDAO build(String daoContent) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            staff = mapper.readValue(daoContent, StaffDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}
