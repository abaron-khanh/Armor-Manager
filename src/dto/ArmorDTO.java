/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PC
 */
public class ArmorDTO implements Serializable{
    private String ArmorId;
    private String Classification;
    private String Description;
    private String Status;
    private Date TimeOfCreate;
    private int Defense;

    public ArmorDTO() {
    }

    public ArmorDTO(String ArmorId, String Classification, String Description, String Status, Date TimeOfCreate, int Defense) {
        this.ArmorId = ArmorId;
        this.Classification = Classification;
        this.Description = Description;
        this.Status = Status;
        this.TimeOfCreate = TimeOfCreate;
        this.Defense = Defense;
    }

    public String getArmorId() {
        return ArmorId;
    }

    public void setArmorId(String ArmorId) {
        this.ArmorId = ArmorId;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String Classification) {
        this.Classification = Classification;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getTimeOfCreate() {
        return TimeOfCreate;
    }

    public void setTiemOfCreate(Date TimeOfCreate) {
        this.TimeOfCreate = TimeOfCreate;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

//    @Override
//    public String toString() {
//        return ArmorId + "," + Classification + "," Description + "," + Status + "," + TimeOfCreate.toString() + "," + Defense;
//        
//        
//    }
//    
    
}
