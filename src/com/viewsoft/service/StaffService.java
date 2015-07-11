/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viewsoft.service;

import com.viewsoft.db.collections.StaffDAO;
import com.viewsoft.model.StaffModel;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author noor
 */
public class StaffService {
    
    private static StaffModel staffModel = new StaffModel();
    public static void main(String args[])
    {
        StaffService staffssService = new StaffService();
        //staffssService.addStaff("{\"firstName\":\"stafffirstname\",\"lastName\":\"stafflastname\",\"bloodGroup\":\"bloodGroup\",\"gender\":\"gender\",\"photo\":\"s2.jpg\",\"mobileNumber\":\"s201712341213\",\"emailAddress\":\"tests2@test.com\",\"presentAddress\":\"presentAddress\",\"permanentAddress\":\"permanentaddress\",\"occupation\":\"occupation\,\"relationWithStaff\":\"relationwithstaff\",\"description\":\"description\"}");
        staffssService.addStaff("{\"firstName\":\"s2myfirstname\",\"lastName\":\"s2mylastname\",\"bloodGroup\":\"bloodGroup\",\"gender\":\"gender\"}");
        //System.out.println(staffssService.getAllStaffs());
    }
    
    public static String addStaff(String additionalData)
    {
        String response = staffModel.addStaff(additionalData);
        return response;
    }
    
    public static List<StaffDAO> getAllStaffs()
    {
        return staffModel.getAllStaffs();
    }
}
