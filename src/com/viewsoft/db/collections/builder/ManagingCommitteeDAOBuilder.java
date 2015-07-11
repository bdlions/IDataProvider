package com.viewsoft.db.collections.builder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewsoft.db.collections.ManagingCommitteeDAO;
import com.viewsoft.db.collections.fragment.BloodGroup;
import com.viewsoft.db.collections.fragment.Gender;
/**
 *
 * @author noor
 */
public class ManagingCommitteeDAOBuilder {    
    private ManagingCommitteeDAO managingCommittee;
    private String _id;
    private String userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private BloodGroup bloodGroup;
    
    public ManagingCommitteeDAOBuilder()
    {
        managingCommittee = new ManagingCommitteeDAO();
    }
    public ManagingCommitteeDAOBuilder set_id(String _id) {
        this._id = _id;
        return this;
    }

    public ManagingCommitteeDAOBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public ManagingCommitteeDAOBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ManagingCommitteeDAOBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public ManagingCommitteeDAOBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
    
    public ManagingCommitteeDAOBuilder setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }
    
    public ManagingCommitteeDAO build()
    {
        managingCommittee.set_id(_id);
        managingCommittee.setUserId(userId);
        managingCommittee.setFirstName(firstName);
        managingCommittee.setLastName(lastName);
        managingCommittee.setBloodGroup(bloodGroup);
        managingCommittee.setGender(gender);  
        
        return managingCommittee;
    }
    
    public ManagingCommitteeDAO build(String daoContent) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            managingCommittee = mapper.readValue(daoContent, ManagingCommitteeDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return managingCommittee;
    }
}
