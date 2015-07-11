package com.viewsoft.db.collections.builder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewsoft.db.collections.GuardianDAO;
import com.viewsoft.db.collections.fragment.BloodGroup;
import com.viewsoft.db.collections.fragment.Gender;
/**
 *
 * @author noor
 */
public class GuardianDAOBuilder {    
    private GuardianDAO guardian;
    private String _id;
    private String userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private BloodGroup bloodGroup;
    
    public GuardianDAOBuilder()
    {
        guardian = new GuardianDAO();
    }
    public GuardianDAOBuilder set_id(String _id) {
        this._id = _id;
        return this;
    }

    public GuardianDAOBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public GuardianDAOBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public GuardianDAOBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public GuardianDAOBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
    
    public GuardianDAOBuilder setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }
    
    public GuardianDAO build()
    {
        guardian.set_id(_id);
        guardian.setUserId(userId);
        guardian.setFirstName(firstName);
        guardian.setLastName(lastName);
        guardian.setBloodGroup(bloodGroup);
        guardian.setGender(gender);  
        
        return guardian;
    }
    
    public GuardianDAO build(String daoContent) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            guardian = mapper.readValue(daoContent, GuardianDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return guardian;
    }
}
