/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viewsoft.db;

import com.viewsoft.db.codec.UserCodec;
import com.viewsoft.db.codec.StudentCodec;
import com.viewsoft.db.codec.TeacherCodec;
import com.viewsoft.db.codec.ManagingCommitteeCodec;
import com.viewsoft.db.codec.StaffCodec;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.viewsoft.db.codec.GuardianCodec;
//import com.viewsoft.db.codec.GenderCodec;

import com.viewsoft.util.PropertyProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

/**
 *
 * @author alamgir
 */
public class DBConnection {

    private static DBConnection instance = null;
    private static MongoDatabase connection = null;

    private String dbUserName;
    private String dbPassword;
    private String dbName;
    private String dbHost;
    private int dbPort;

    private DBConnection() {
        //singleton class for the database connection
        if (instance == null) {
            /**
             * Reading form the property file
             */
            PropertyProvider.add("database");

            /**
             * All setting up the host, port, username and password
             */
            setDbHost(PropertyProvider.get("host"));
            setDbUserName(PropertyProvider.get("username"));
            setDbPassword(PropertyProvider.get("password"));
            setDbPort(Integer.parseInt(PropertyProvider.get("port")));
            setDbName(PropertyProvider.get("dbname"));

            //UserCodec userCodec = new UserCodec();
            UserCodec userCodec = new UserCodec();
            TeacherCodec teacherCodec = new TeacherCodec();
            StudentCodec studentsCodec = new StudentCodec();            
            GuardianCodec guardianCodec = new GuardianCodec();
            //GenderCodec genderCodec = new GenderCodec(); 
            ManagingCommitteeCodec managingCommitteesCodec = new ManagingCommitteeCodec();
            StaffCodec staffCodec = new StaffCodec();
            CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                    MongoClient.getDefaultCodecRegistry(),
                    CodecRegistries.fromCodecs(userCodec),
                    CodecRegistries.fromCodecs(teacherCodec),
                    CodecRegistries.fromCodecs(studentsCodec),
                    CodecRegistries.fromCodecs(guardianCodec),
                    CodecRegistries.fromCodecs(managingCommitteesCodec),
                    CodecRegistries.fromCodecs(staffCodec)
                    //CodecRegistries.fromCodecs(genderCodec)
            );

            MongoClientOptions options = MongoClientOptions.builder().codecRegistry(codecRegistry).build();

            ServerAddress serverAddress = new ServerAddress(dbHost, dbPort);
            MongoClient mongoClient = new MongoClient(serverAddress, options);
            
            connection = mongoClient.getDatabase(dbName);

        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public MongoDatabase getConnection() {
        return connection;
    }

    private void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    private void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    private void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    private void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    private void setDbName(String dbName) {
        this.dbName = dbName;
    }

}
