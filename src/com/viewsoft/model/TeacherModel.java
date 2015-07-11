package com.viewsoft.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.viewsoft.db.DBConnection;
import com.viewsoft.db.collections.TeacherDAO;
import com.viewsoft.db.collections.builder.TeacherDAOBuilder;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;

/**
 *
 * @author nazmul hasan
 */
public class TeacherModel {
    public String addTeacher(String additionalData)
    {
        String response = "";
        MongoCollection<TeacherDAO> mongoCollectionTeachers
                = DBConnection.getInstance().getConnection().getCollection("teachers", TeacherDAO.class); 
        TeacherDAO teacherInfo = new TeacherDAOBuilder().build(additionalData);
        mongoCollectionTeachers.insertOne(teacherInfo);
        
        return response;
    }
    
    public List<TeacherDAO> getAllTeachers()
    {
        DBConnection.getInstance().getConnection();
        MongoCollection<TeacherDAO> mongoCollection
                = DBConnection.getInstance().getConnection().getCollection("teachers", TeacherDAO.class);
        MongoCursor<TeacherDAO> cursorCountryList = mongoCollection.find().iterator();
        List<TeacherDAO> teacherList = IteratorUtils.toList(cursorCountryList);
        return teacherList;
    }
    
    public void updateTeacher()
    {
    
    }
}
