/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dao.ArmorDAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author PC
 */
public class ArmorServer extends UnicastRemoteObject implements ArmorInterface{
    
    public ArmorServer() throws RemoteException
    {
        super();
    }
    
    @Override
    public boolean createArmor(ArmorDTO dto) {
        return ArmorDAO.createArmor(dto);
    }

    @Override
    public ArmorDTO findByArmorID(String id) {
        return ArmorDAO.findByArmorID(id);
    }

    @Override
    public List<ArmorDTO> findAllArmor() {
        return ArmorDAO.loadAllArmor("ArmorData.txt");
    }

    @Override
    public boolean removeArmor(String id) {
        return ArmorDAO.removeArmor(id);
    }

    @Override
    public boolean updateArmor(ArmorDTO dto) {
        return ArmorDAO.updateArmor(dto);
    }
    
    
}
  