/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viewsoft.service;

import com.viewsoft.db.collections.ManagingCommitteeDAO;
import com.viewsoft.model.ManagingCommitteeModel;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author noor
 */
public class ManagingCommitteeService {
    
    private static ManagingCommitteeModel managingCommitteeModel = new ManagingCommitteeModel();
    public static void main(String args[])
    {
        ManagingCommitteeService managingCommitteessService = new ManagingCommitteeService();
        
        managingCommitteessService.addManagingCommittee("{\"firstName\":\"s2myfirstname\",\"lastName\":\"s2mylastname\",\"fatherName\":\"fathername\",\"motherName\":\"mothername\",\"bloodGroup\":\"bloodGroup\",\"gender\":\"gender\",\"photo\":\"s2.jpg\",\"mobileNumber\":\"s201712341213\",\"emailAddress\":\"tests2@test.com\",\"presentAddress\":\"presentAddress\",\"permanentAddress\":\"s2mypermanentaddress\",\"designation\":\"designation\",\"identity\":\"identity\",\"description\":\"description\"}");
        //System.out.println(managingCommitteessService.getAllManagingCommittees());
    }
    
    public static String addManagingCommittee(String additionalData)
    {
        String response = managingCommitteeModel.addManagingCommittee(additionalData);
        return response;
    }
    
    public static List<ManagingCommitteeDAO> getAllManagingCommittees()
    {
        return managingCommitteeModel.getAllManagingCommittees();
    }
}
