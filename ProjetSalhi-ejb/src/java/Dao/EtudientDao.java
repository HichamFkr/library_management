/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.Etudient;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface EtudientDao extends AbstractDao<Etudient>{
    
    ArrayList<Etudient> getBySearch(String search);
    
}
