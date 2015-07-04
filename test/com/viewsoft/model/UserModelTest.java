package com.viewsoft.model;

import com.viewsoft.db.collections.UserDAO;
import com.viewsoft.db.collections.builder.UserDAOBuilder;
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
public class UserModelTest {

    public UserModelTest() {
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

    @Test
    public void main() {
        DBConnection.getInstance().getConnection();
        MongoCollection<UserDAO> mongoCollection
                = DBConnection.getInstance().getConnection().getCollection("users", UserDAO.class);

        
        UserDAO userInfo = new UserDAOBuilder()
                .setFirstName("Nazmul")
                .setLastName("Hasan")
                .setFatherName("myfather")
                .setMotherName("mymother")
                .setPhoto("1.jpg")
                .setPhone("myphoone")
                .setEmail("a@test.com")
                .setBloodGroup("myblood")
                .setCurrentAddress("mycurrentaddress")
                .setPermanentAddress("mypermanentaddress")
                .build();
        mongoCollection.insertOne(userInfo); 
        
        MongoCursor userProfiles = mongoCollection.find().iterator();
        while (userProfiles.hasNext()) {
            UserDAO dbUserInfo = (UserDAO) userProfiles.next();
            System.out.println(dbUserInfo);
        }
    }

}
