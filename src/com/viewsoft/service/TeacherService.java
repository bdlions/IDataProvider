/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viewsoft.service;

import com.viewsoft.db.collections.TeacherDAO;
import com.viewsoft.model.TeacherModel;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author nazmul
 */
public class TeacherService {
    private static TeacherModel teacherModel = new TeacherModel();
    public static void main(String args[])
    {   
        TeacherService teacherService = new TeacherService();
        teacherService.addTeacher("{\"firstName\":\"myfirstname2\",\"lastName\":\"mylastname2\",\"fatherName\":\"myFatherName2\",\"motherName\":\"myMothername2\",\"photo\":\"2.jpg\",\"phone\":\"01712341213\",\"email\":\"test2@test.com\",\"bloodGroup\":\"A+\",\"currentAddress\":\"myCurrentAddress2\",\"permanentAddress\":\"mypermanentaddress2\",\"designation\":\"mydesignation2\"}");
        //System.out.println(teacherService.getAllTeachers());
    }
    public static String addTeacher(String additionalData)
    {
        String response = teacherModel.addTeacher(additionalData);
        return response;
    }
    
    public static List<TeacherDAO> getAllTeachers()
    {
        return teacherModel.getAllTeachers();
    }
}
