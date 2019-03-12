/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daoImp;

import Dao.UserDao;
import bo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;


/**
 *
 * @author ASUS
 */

public class UseDaoImp implements UserDao{
  
    private final String sqlGetLogin = "select * from user where motPass = ? and email = ? ";
    
     @Override
    public User getByLogin(String email, String motpass) {
        User u = null;
        Connection c = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c, sqlGetLogin, false, motpass,email);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {                
                 u = mapping(resultSet);
            }  
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return u;
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

    @Override
    public User mapping(ResultSet r) {
       User u = new User();
        try {        
            u.setEmail(r.getString("email"));
            u.setMotpass(r.getString("motpass"));
            u.setId(r.getLong("id"));
            u.setNom(r.getString("nom"));
            u.setPrenom(r.getString("prenom"));
        } catch (SQLException ex) {
            Logger.getLogger(UseDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
}
