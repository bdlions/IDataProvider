package com.viewsoft.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.viewsoft.db.DBConnection;
import com.viewsoft.db.collections.ManagingCommitteeDAO;
import com.viewsoft.db.collections.builder.ManagingCommitteeDAOBuilder;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;

/**
 *
 * @author nazmul hasan
 */
public class ManagingCommitteeModel {
    public String addManagingCommittee(String additionalData)
    {
        String response = "";
        MongoCollection<ManagingCommitteeDAO> mongoCollectionManagingCommittees
                = DBConnection.getInstance().getConnection().getCollection("managingCommittees", ManagingCommitteeDAO.class); 
        ManagingCommitteeDAO managingCommitteeInfo = new ManagingCommitteeDAOBuilder().build(additionalData);
        mongoCollectionManagingCommittees.insertOne(managingCommitteeInfo);
        
        return response;
    }
    
    public List<ManagingCommitteeDAO> getAllManagingCommittees()
    {
        DBConnection.getInstance().getConnection();
        MongoCollection<ManagingCommitteeDAO> mongoCollection
                = DBConnection.getInstance().getConnection().getCollection("managingCommittees", ManagingCommitteeDAO.class);
        MongoCursor<ManagingCommitteeDAO> cursorCountryList = mongoCollection.find().iterator();
        List<ManagingCommitteeDAO> managingCommitteeList = IteratorUtils.toList(cursorCountryList);
        return managingCommitteeList;
    }
    
    public void updateManagingCommittee()
    {
    
    }
}
