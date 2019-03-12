/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Dao.EtudientDao;
import bo.Etudient;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface EtudientService extends AbstractService<Etudient> {
     ArrayList<Etudient> getBySearch(String search);
}
