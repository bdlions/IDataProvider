package com.viewsoft.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.viewsoft.db.DBConnection;
import com.viewsoft.db.collections.GuardianDAO;
import com.viewsoft.db.collections.builder.GuardianDAOBuilder;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;

/**
 *
 * @author nazmul hasan
 */
public class GuardianModel {
    public String addGuardian(String additionalData)
    {
        String response = "";
        MongoCollection<GuardianDAO> mongoCollectionGuardians
                = DBConnection.getInstance().getConnection().getCollection("guardians", GuardianDAO.class); 
        GuardianDAO guardianInfo = new GuardianDAOBuilder().build(additionalData);
        mongoCollectionGuardians.insertOne(guardianInfo);
        
        return response;
    }
    
    public List<GuardianDAO> getAllGuardians()
    {
        DBConnection.getInstance().getConnection();
        MongoCollection<GuardianDAO> mongoCollection
                = DBConnection.getInstance().getConnection().getCollection("guardians", GuardianDAO.class);
        MongoCursor<GuardianDAO> cursorCountryList = mongoCollection.find().iterator();
        List<GuardianDAO> guardianList = IteratorUtils.toList(cursorCountryList);
        return guardianList;
    }
    
    public void updateGuardian()
    {
    
    }
}
