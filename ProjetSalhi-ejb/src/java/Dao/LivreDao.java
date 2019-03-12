/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.Livre;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface LivreDao extends AbstractDao<Livre>{
     ArrayList<Livre> getSearch(String search);
}
