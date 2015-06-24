package com.bdit.model;

import com.bdit.db.collections.UserDAO;
import com.bdit.db.collections.builder.UserDAOBuilder;
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
                .build();
        mongoCollection.insertOne(userInfo); 
        
        MongoCursor userProfiles = mongoCollection.find().iterator();
        while (userProfiles.hasNext()) {
            UserDAO dbUserInfo = (UserDAO) userProfiles.next();
            System.out.println(dbUserInfo);
        }
    }

}
