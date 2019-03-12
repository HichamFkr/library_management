/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daoFactory;

import Dao.EtudientDao;
import Dao.ListeDesPretsDao;
import Dao.LivreDao;
import Dao.UserDao;
import bo.Etudient;
import daoImp.EtudientDaoImp;
import daoImp.ListeDesPretsDaoImp;
import daoImp.LivreDaoImp;
import daoImp.UseDaoImp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DaoFactory {
    
    private static EtudientDao etudientDao;
    private static LivreDao livreDao;
    private static ListeDesPretsDao listeDesPretsDao;
    private static UserDao userDao;

    public static UserDao getUserDao() {
        if(userDao == null)
            userDao = new UseDaoImp();
        return userDao;
    }

    
    public static EtudientDao getEtudientDao() {
        if(etudientDao == null)
            etudientDao = new EtudientDaoImp();
        return etudientDao;
    }

    public static LivreDao getLivreDao() {
        if(livreDao == null)
            livreDao = new LivreDaoImp();
        return livreDao;
    }

    public static ListeDesPretsDao getListeDesPretsDao() {
        if(listeDesPretsDao == null)
            listeDesPretsDao = new ListeDesPretsDaoImp();
        return listeDesPretsDao;
    }
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
        }
        
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque", "root","");
    }
    public static void main(String[] args) {
        Etudient e = new Etudient();
        e.setEmail("ddd");
        e.setMatricule("ff");
      
    }
    
}
