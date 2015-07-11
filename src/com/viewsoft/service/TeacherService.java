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
 * @author noor
 */
public class TeacherService {
    
    private static TeacherModel teacherModel = new TeacherModel();
    public static void main(String args[])
    {
        TeacherService teacherssService = new TeacherService();
        //teacherssService.addTeacher("{\"firstName\":\"teacherfirstname\",\"lastName\":\"teacherlastname\",\"bloodGroup\":\"bloodGroup\",\"gender\":\"gender\",\"photo\":\"s2.jpg\",\"mobileNumber\":\"s201712341213\",\"emailAddress\":\"tests2@test.com\",\"presentAddress\":\"presentAddress\",\"permanentAddress\":\"permanentaddress\",\"occupation\":\"occupation\,\"relationWithTeacher\":\"relationwithteacher\",\"description\":\"description\"}");
        teacherssService.addTeacher("{\"firstName\":\"s2myfirstname\",\"lastName\":\"s2mylastname\",\"bloodGroup\":\"bloodGroup\",\"gender\":\"gender\"}");
        //System.out.println(teacherssService.getAllTeachers());
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
