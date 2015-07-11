/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viewsoft.service;

import com.viewsoft.db.collections.GuardianDAO;
import com.viewsoft.model.GuardianModel;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author noor
 */
public class GuardianService {
    
    private static GuardianModel guardianModel = new GuardianModel();
    public static void main(String args[])
    {
        GuardianService guardianssService = new GuardianService();
        //guardianssService.addGuardian("{\"firstName\":\"guardianfirstname\",\"lastName\":\"guardianlastname\",\"bloodGroup\":\"bloodGroup\",\"gender\":\"gender\",\"photo\":\"s2.jpg\",\"mobileNumber\":\"s201712341213\",\"emailAddress\":\"tests2@test.com\",\"presentAddress\":\"presentAddress\",\"permanentAddress\":\"permanentaddress\",\"occupation\":\"occupation\,\"relationWithGuardian\":\"relationwithguardian\",\"description\":\"description\"}");
        guardianssService.addGuardian("{\"firstName\":\"s2myfirstname\",\"lastName\":\"s2mylastname\",\"bloodGroup\":\"bloodGroup\",\"gender\":\"gender\"}");
        //System.out.println(guardianssService.getAllGuardians());
    }
    
    public static String addGuardian(String additionalData)
    {
        String response = guardianModel.addGuardian(additionalData);
        return response;
    }
    
    public static List<GuardianDAO> getAllGuardians()
    {
        return guardianModel.getAllGuardians();
    }
}
