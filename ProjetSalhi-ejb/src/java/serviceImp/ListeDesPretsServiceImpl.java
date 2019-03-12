/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serviceImp;

import Service.ListeDesPretsService;
import bo.ListeDesPrets;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author ASUS
 */
@Stateless
public class ListeDesPretsServiceImpl implements ListeDesPretsService{

    @Override
    public long save(ListeDesPrets obj) {
        return daoFactory.DaoFactory.getListeDesPretsDao().save(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        daoFactory.DaoFactory.getListeDesPretsDao().delete(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ListeDesPrets obj, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ListeDesPrets> getAll() {
      return daoFactory.DaoFactory.getListeDesPretsDao().getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListeDesPrets getById(long id) {
        return daoFactory.DaoFactory.getListeDesPretsDao().getById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ListeDesPrets> getByIdEtudient(long id) {
        return daoFactory.DaoFactory.getListeDesPretsDao().getByIdEtudient(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ListeDesPrets> getByIdLivre(long id) {
        return daoFactory.DaoFactory.getListeDesPretsDao().getByIdLivre(id); //To change body of generated methods, choose Tools | Templates.
    }
    
}
