package com.bdit.model;

import com.bdit.db.collections.TeacherDAO;
import com.bdit.db.collections.builder.TeacherDAOBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.shampan.db.DBConnection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author alamgir
 */
public class TeacherModelTest {

    public TeacherModelTest() {
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
        MongoCollection<TeacherDAO> mongoCollection
                = DBConnection.getInstance().getConnection().getCollection("teachers", TeacherDAO.class);

        
        TeacherDAO teacherInfo = new TeacherDAOBuilder()
                .setUserId("1")
                .setDesignation("Principal")
                .build();
        mongoCollection.insertOne(teacherInfo); 
        
        //List<StudentsDAO> studentList = new ArrayList<StudentsDAO>();
        MongoCursor userProfiles = mongoCollection.find().iterator();
        while (userProfiles.hasNext()) {
            TeacherDAO dbStudentInfo = (TeacherDAO) userProfiles.next();
            System.out.println(dbStudentInfo);
        }
    }

}
