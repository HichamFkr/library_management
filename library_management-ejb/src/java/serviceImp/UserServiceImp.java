/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serviceImp;

import Service.UserService;
import bo.User;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author ASUS
 */
@Stateless
public class UserServiceImp implements UserService{

    @Override
    public User getByLogin(String email, String motpass) {
        return daoFactory.DaoFactory.getUserDao().getByLogin(email, motpass); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long save(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User obj, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
