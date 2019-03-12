/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serviceImp;
import Dao.EtudientDao;
import Service.EtudientService;
import bo.Etudient;
import daoImp.EtudientDaoImp;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.ejb.Stateless;
/**
 *
 * @author ASUS
 */
@Stateless
public class EtudientServiceImp implements EtudientService {
 
   
    @Override
    public long save(Etudient obj) {
        return daoFactory.DaoFactory.getEtudientDao().save(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        daoFactory.DaoFactory.getEtudientDao().delete(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Etudient obj, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Etudient> getAll() {
      return daoFactory.DaoFactory.getEtudientDao().getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudient getById(long id) {
        return daoFactory.DaoFactory.getEtudientDao().getById(id); //To change body of generated methods, choose Tools | Templates.
    }  
    public static void main(String[] args) {
        EtudientDao e = new EtudientDaoImp();
        ArrayList<Etudient> l = e.getBySearch("m");
        for (Etudient etudient : l) {
            System.out.println(etudient.getEmail());
        }
    }

    @Override
    public ArrayList<Etudient> getBySearch(String search) {
        return daoFactory.DaoFactory.getEtudientDao().getBySearch(search); //To change body of generated methods, choose Tools | Templates.
    }
}
