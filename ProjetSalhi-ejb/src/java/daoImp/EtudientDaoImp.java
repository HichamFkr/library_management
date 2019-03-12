/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import Dao.EtudientDao;
import bo.Etudient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class EtudientDaoImp implements EtudientDao {

    
    private final String sqlInsert = "insert into etudient(email,matricule,nom,prenom)values(?,?,?,?)";
    private final String sqlDelete = "delete from etudient where id = ? ";
    private final String sqlGetAll = "select * from etudient order by nom";
    private final String sqlGetById = "select * from etudient where id = ?";
    private final String sqlSearch = "select * from etudient where nom like";
   

    @Override
    public long save(Etudient obj) {
      long id =0;
      Connection c = null;
      PreparedStatement preparedStatement = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c, sqlInsert, true, obj.getEmail(),obj.getMatricule(),obj.getNom(),obj.getPrenom());
            id = preparedStatement.executeUpdate();
            c.close();
        } catch (Exception e) {
        }
      
      return id;
    }

    @Override
    public void delete(long id) {
        Connection c = null; 
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c, sqlDelete, false, id);
            int statu = preparedStatement.executeUpdate();
            c.close();
        }catch(Exception e){
            System.out.println("ee"+e.getMessage());
        }
    }

    @Override
    public void update(Etudient obj, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Etudient> getAll() {
        Connection c = null; 
        ArrayList<Etudient> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = c.prepareStatement(sqlGetAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                list.add(mapping(resultSet));
            }
            c.close();
        } catch (Exception e) {
        }
        return  list;
    }

    @Override
    public Etudient getById(long id) {
       Etudient etudient = null;
        Connection c = null; 
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c, sqlGetById, false, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            etudient = mapping(resultSet);
            c.close();
        } catch (Exception e) {
        }
        return etudient;
    }

    @Override
    public Etudient mapping(ResultSet r) {
        Etudient e = new Etudient();
        try {
            e.setId(r.getLong("id"));
            e.setEmail(r.getString("email"));
            e.setMatricule(r.getString("matricule"));
            e.setNom(r.getString("nom"));
            e.setPrenom(r.getString("prenom"));
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return e;
    }
    void init(Etudient old, Etudient newObje) {
        old.setEmail(newObje.getEmail());
        old.setMatricule(newObje.getMatricule());
        
        old.setNom(newObje.getNom());
        old.setPrenom(newObje.getPrenom());
    }

    @Override
    public ArrayList<Etudient> getBySearch(String search) {
         Connection c = null; 
        ArrayList<Etudient> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = c.prepareStatement(sqlSearch+"'"+search+"%'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                list.add(mapping(resultSet));
            }
            c.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  list; //To change body of generated methods, choose Tools | Templates.
    }
   
}
