/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class ArmorTableModel <E> extends AbstractTableModel{
    String[] header;
    int[] indexes;
    Vector<ArmorDTO> armorData;

    public ArmorTableModel(String[] header, int[] indexes) {
        int i=0;
        this.header = new String[header.length];
        for (i = 0; i < header.length; i++) 
        {
            this.header[i]=header[i];
        }
        this.indexes = new int[indexes.length];
        for(i=0; i<header.length; i++)
        {
            this.indexes[i]=indexes[i];
        }
        this.armorData = new Vector<ArmorDTO>();
    }

    public Vector<ArmorDTO> getArmorData() {
        return armorData;
    }

    public void setArmorData(Vector<ArmorDTO> armorData) {
        this.armorData = armorData;
    }

    @Override
    public int getRowCount() {
        return armorData.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return (column>=0 && column<header.length)?header[column]:"";
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex<0 || rowIndex>=armorData.size() || columnIndex<0 || columnIndex>=header.length)
            return null;
        ArmorDTO armor = armorData.get(rowIndex);
        switch(indexes[columnIndex])
        {
            case 0: return armor.getArmorId();
            case 1: return armor.getClassification();
            case 2: return armor.getDescription();
            case 3: return armor.getStatus();
            case 4: return armor.getTimeOfCreate();
            case 5: return armor.getDefense();
        }
        return null;
    }
    
}
