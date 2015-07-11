package com.viewsoft.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.viewsoft.db.DBConnection;
import com.viewsoft.db.collections.StaffDAO;
import com.viewsoft.db.collections.builder.StaffDAOBuilder;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;

/**
 *
 * @author nazmul hasan
 */
public class StaffModel {
    public String addStaff(String additionalData)
    {
        String response = "";
        MongoCollection<StaffDAO> mongoCollectionStaffs
                = DBConnection.getInstance().getConnection().getCollection("staffs", StaffDAO.class); 
        StaffDAO staffInfo = new StaffDAOBuilder().build(additionalData);
        mongoCollectionStaffs.insertOne(staffInfo);
        
        return response;
    }
    
    public List<StaffDAO> getAllStaffs()
    {
        DBConnection.getInstance().getConnection();
        MongoCollection<StaffDAO> mongoCollection
                = DBConnection.getInstance().getConnection().getCollection("staffs", StaffDAO.class);
        MongoCursor<StaffDAO> cursorCountryList = mongoCollection.find().iterator();
        List<StaffDAO> staffList = IteratorUtils.toList(cursorCountryList);
        return staffList;
    }
    
    public void updateStaff()
    {
    
    }
}
