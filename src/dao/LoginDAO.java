/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AccountDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author PC
 */
public class LoginDAO implements Serializable{
    
    public static List<AccountDTO> getAccount(){
        List<AccountDTO> accountList= new ArrayList<AccountDTO>();
        try {
            FileReader f = new FileReader ("Account.txt");
            BufferedReader br = new BufferedReader (f);
            String line;
            StringTokenizer stk;
           
            while ((line = br.readLine()) != null){
                stk = new StringTokenizer(line, ",");
                String user = stk.nextToken();
                String password = stk.nextToken();
                AccountDTO dto = new AccountDTO(user, password);
                accountList.add(dto);
            }
            br.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         return accountList;
    }
    
    public boolean checkLogin(String user, String password)
    {
        List<AccountDTO> checkList = getAccount();
        for(int i = 0; i < checkList.size(); i++)
        {
            if(checkList.get(i).getUser().equals(user) && checkList.get(i).getPassword().equals(password))
                return true;
        }
        return false;
    }
    
}
