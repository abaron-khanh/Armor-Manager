/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ArmorDTO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ArmorDAO implements Serializable{
    public static String filename = "ArmorData.txt";
    
    public ArmorDAO() {
    }
    
    public static List<ArmorDTO> loadAllArmor(String filename)
    {
        List<ArmorDTO> list =new Vector<>();
        try {            
            FileReader f = new FileReader(filename);
            BufferedReader br = new BufferedReader(f);
            String line;
            StringTokenizer stk;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            while ((line = br.readLine()) != null){
                stk = new StringTokenizer(line, ",");
                String id = stk.nextToken();
                String Classification = stk.nextToken();
                String Description = stk.nextToken();
                String Status = stk.nextToken();
                Date TimeOfCreate = simpleDateFormat.parse(stk.nextToken());
                int defense = Integer.parseInt(stk.nextToken());
                ArmorDTO dto = new ArmorDTO(id, Classification, Description, Status, TimeOfCreate, defense);
                list.add(dto);
            }
            br.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static List<ArmorDTO> findAllArmor(){
        List<ArmorDTO> list = loadAllArmor(filename);
        return list;
    }
    
    public static boolean createArmor(ArmorDTO armorDTO){
        List<ArmorDTO> list = loadAllArmor(filename);
        boolean check = list.add(armorDTO);
        if(check == true)
        {
            saveArmors(list);
            return true;
        }
        return false;
    }
    
    public static void saveArmors(List<ArmorDTO> list){
        try {
            FileWriter f = new FileWriter (filename);
            PrintWriter pw = new PrintWriter(f);
            String line="";
            for (ArmorDTO armorDTO : list)
            {
                line = armorDTO.getArmorId() + "," + armorDTO.getClassification()+ "," + armorDTO.getDescription()+ "," + armorDTO.getStatus()+ "," + armorDTO.getTimeOfCreate()+ "," + armorDTO.getDefense();
                pw.println(line);
            }
            pw.close();
            f.close();
        } catch (FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(ArmorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArmorDTO findByArmorID(String id){
        List<ArmorDTO> list = loadAllArmor(filename);
        for (ArmorDTO armorDTO : list){
            if (id.equals(armorDTO.getArmorId()))
            {
                return armorDTO;
            }
        }
        return null;
    }
    
    public static boolean removeArmor (String id){
        List<ArmorDTO> list = loadAllArmor(filename);
        for (int i = 0; i < list.size(); i++) 
        {
            if(id.equalsIgnoreCase(list.get(i).getArmorId().toUpperCase()))
            {
                list.remove(i);
                saveArmors(list);
                return true;
            }
        }
        return false;
    }
    
    public static boolean updateArmor (ArmorDTO armorDTO){
        List<ArmorDTO> list = loadAllArmor(filename);
        for (int i = 0; i < list.size(); i++) 
        {
            if(armorDTO.getArmorId().equalsIgnoreCase(list.get(i).getArmorId()))
            {
                list.set(i, armorDTO);
                saveArmors(list);
                return true;
            }
        }
        return false;
    
    }
}
