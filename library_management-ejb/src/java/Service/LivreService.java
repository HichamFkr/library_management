/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import bo.Livre;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface LivreService extends AbstractService<Livre>{
   
    ArrayList<Livre>getBySearch(String search);
}
