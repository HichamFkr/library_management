/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serviceImp;

import Service.LivreService;
import bo.Livre;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author ASUS
 */
@Stateless
public class LivreServiceImp implements LivreService{

    @Override
    public long save(Livre obj) {
        return daoFactory.DaoFactory.getLivreDao().save(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        daoFactory.DaoFactory.getLivreDao().delete(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Livre obj, long id) {
        daoFactory.DaoFactory.getLivreDao().update(obj, id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Livre> getAll() {
      return daoFactory.DaoFactory.getLivreDao().getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Livre getById(long id) {
        return daoFactory.DaoFactory.getLivreDao().getById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Livre> getBySearch(String search) {
        
       return daoFactory.DaoFactory.getLivreDao().getSearch(search);//To change body of generated methods, choose Tools | Templates.
    }
    
}
