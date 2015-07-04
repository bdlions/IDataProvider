package com.viewsoft.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.viewsoft.db.DBConnection;
import com.viewsoft.db.collections.StudentDAO;
import com.viewsoft.db.collections.builder.StudentDAOBuilder;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;

/**
 *
 * @author nazmul hasan
 */
public class StudentModel {
    public String addStudent(String additionalData)
    {
        String response = "";
        MongoCollection<StudentDAO> mongoCollectionStudents
                = DBConnection.getInstance().getConnection().getCollection("students", StudentDAO.class); 
        StudentDAO studentInfo = new StudentDAOBuilder().build(additionalData);
        mongoCollectionStudents.insertOne(studentInfo);
        
        return response;
    }
    
    public List<StudentDAO> getAllStudents()
    {
        DBConnection.getInstance().getConnection();
        MongoCollection<StudentDAO> mongoCollection
                = DBConnection.getInstance().getConnection().getCollection("students", StudentDAO.class);
        MongoCursor<StudentDAO> cursorCountryList = mongoCollection.find().iterator();
        List<StudentDAO> studentList = IteratorUtils.toList(cursorCountryList);
        return studentList;
    }
    
    public void updateStudent()
    {
    
    }
}
