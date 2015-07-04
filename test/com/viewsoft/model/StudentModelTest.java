package com.viewsoft.model;

import com.viewsoft.db.collections.StudentDAO;
import com.viewsoft.db.collections.builder.StudentDAOBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.viewsoft.db.DBConnection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author nazmul hasan
 */
public class StudentModelTest {

    public StudentModelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void main() {
        DBConnection.getInstance().getConnection();
        MongoCollection<StudentDAO> mongoCollection
                = DBConnection.getInstance().getConnection().getCollection("students", StudentDAO.class);

        
        StudentDAO studentInfo = new StudentDAOBuilder()
                .setUserId("1")
                .build();
        mongoCollection.insertOne(studentInfo); 
        
        //List<StudentsDAO> studentList = new ArrayList<StudentsDAO>();
        MongoCursor userProfiles = mongoCollection.find().iterator();
        while (userProfiles.hasNext()) {
            StudentDAO dbStudentInfo = (StudentDAO) userProfiles.next();
            System.out.println(dbStudentInfo);
        }
    }

}
