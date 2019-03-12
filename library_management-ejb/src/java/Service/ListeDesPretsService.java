/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import bo.ListeDesPrets;
import bo.Livre;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface ListeDesPretsService extends AbstractService<ListeDesPrets>{
     ArrayList<ListeDesPrets>getByIdEtudient(long id);
      ArrayList<ListeDesPrets>getByIdLivre(long id);
}
