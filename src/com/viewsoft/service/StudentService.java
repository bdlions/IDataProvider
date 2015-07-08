/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viewsoft.service;

import com.viewsoft.db.collections.StudentDAO;
import com.viewsoft.db.collections.builder.StudentDAOBuilder;
import com.viewsoft.db.collections.fragment.BloodGroup;
import com.viewsoft.db.collections.fragment.Gender;
import com.viewsoft.model.StudentModel;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author nazmul
 */
public class StudentService {
    
    private static StudentModel studentModel = new StudentModel();
    public static void main(String args[])
    {
        StudentService studenService = new StudentService();
        //studenService.addStudent("{\"firstName\":\"s2myfirstname\",\"lastName\":\"s2mylastname\",\"fatherName\":\"s2myFatherName\",\"motherName\":\"s2myMothername\",\"photo\":\"s2.jpg\",\"phone\":\"s201712341213\",\"email\":\"tests2@test.com\",\"bloodGroup\":\"A+\",\"currentAddress\":\"s2myCurrentAddress\",\"permanentAddress\":\"s2mypermanentaddress\",\"designation\":\"s2mydesignation\",\"gender\":\"{\"_id\":\"1\",\"title\":\"Male\"}\"}");
        Gender gender = new Gender();
        gender.set_id("1");
        gender.setTitle("Male");
        BloodGroup bloodGroup = new BloodGroup();
        bloodGroup.set_id("1");
        bloodGroup.setTitle("A+");
        StudentDAOBuilder studentDAOBuilder = new StudentDAOBuilder()
                                                    .setFirstName("s1noor")
                                                    .setLastName("s1lalam")
                                                    .setGender(gender)
                                                    .setBloodGroup(bloodGroup);
        StudentDAO sutdentDAO = studentDAOBuilder.build();
        studenService.addStudent(sutdentDAO.toString());
        //System.out.println(studenService.getAllStudents());
    }
    
    public static String addStudent(String additionalData)
    {
        String response = studentModel.addStudent(additionalData);
        return response;
    }
    
    public static List<StudentDAO> getAllStudents()
    {
        return studentModel.getAllStudents();
    }
}
