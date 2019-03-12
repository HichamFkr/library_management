/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImp;

import Dao.EtudientDao;
import Dao.ListeDesPretsDao;
import Dao.LivreDao;
import bo.ListeDesPrets;
import bo.Livre;
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
public class ListeDesPretsDaoImp implements ListeDesPretsDao {

    private final String sqlGetAll = "select * from listedesprets order by idEtudient ";
    private final String sqlGetById = "select * from listedesprets where id = ? ";
    private final String sqlInsert = "insert into listedesprets(isRetourne,idEtudient,idLivre)values(?,?,?)";
    private final String sqlDelete = "delete from listedesprets where id = ?";
    private final String sqlGetByIdEtudient = "select * from listedesprets where idEtudient = ? ";
    private final String sqlGetByIdLivre = "select * from listedesprets where idLivre = ? ";
    
    @Override
    public long save(ListeDesPrets obj) {
        long id = 0;
        Connection c = null;
        PreparedStatement preparedStatement = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c, sqlInsert, true, obj.getIsRetourne(), obj.getEtudient().getId(), obj.getLivre().getId());
            id = preparedStatement.executeUpdate();
            c.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return id;
    }

    @Override
    public void delete(long id) {
        Connection c = null;
        PreparedStatement preparedStatement = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c, sqlDelete, false, id);
            int statu = preparedStatement.executeUpdate();
            c.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void update(ListeDesPrets obj, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ListeDesPrets> getAll() {
        Connection c = null;
        PreparedStatement preparedStatement = null;
        ArrayList<ListeDesPrets> list = new ArrayList<>();
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = c.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(mapping(resultSet));
            }
            c.close();
        } catch (Exception e) {
        } //To change body of generated methods, choose Tools | Templates.
        return list;
    }

    @Override
    public ListeDesPrets getById(long id) {
        ListeDesPrets listeDesPrets = null;
        Connection c = null;
        PreparedStatement preparedStatement = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c, sqlGetById, true, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                listeDesPrets = mapping(resultSet);
            c.close();
        } catch (Exception e) {
        }
        return listeDesPrets;
    }

    @Override
    public ListeDesPrets mapping(ResultSet r) {
       ListeDesPrets listeDesPrets = new ListeDesPrets();
       EtudientDao etudientDao = new EtudientDaoImp();
       LivreDao livreDao = new LivreDaoImp();
        try {
            listeDesPrets.setId(r.getLong("id"));
            listeDesPrets.setEtudient(etudientDao.getById(r.getLong("idEtudient")));
            listeDesPrets.setIsRetourne(r.getBoolean("isRetourne"));
            listeDesPrets.setLivre(livreDao.getById(r.getLong("idLivre")));
        } catch (SQLException ex) {
            Logger.getLogger(ListeDesPretsDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return listeDesPrets;
    }

    public static void main(String[] args) {
        EtudientDao e = new EtudientDaoImp();
        LivreDao l = new LivreDaoImp();
        ListeDesPrets ldp = new ListeDesPrets();
        System.out.println("hhh");
        Livre liv = l.getById(3);
        liv.setExemplaire(4);
      l.update(liv, liv.getId());
    }

    @Override
    public ArrayList<ListeDesPrets> getByIdEtudient(long id) {
       Connection c = null;
        PreparedStatement preparedStatement = null;
        ArrayList<ListeDesPrets> list = new ArrayList<>();
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c, sqlGetByIdEtudient, true, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(mapping(resultSet));
            }
            c.close();
        } catch (Exception e) {
            System.out.println("err "+e.getMessage());
        } //To change body of generated methods, choose Tools | Templates.
        return list; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ListeDesPrets> getByIdLivre(long id) {
          Connection c = null;
        PreparedStatement preparedStatement = null;
        ArrayList<ListeDesPrets> list = new ArrayList<>();
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c,sqlGetByIdLivre, true, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(mapping(resultSet));
            }
            c.close();
        } catch (Exception e) {
            System.out.println("err "+e.getMessage());
        } //To change body of generated methods, choose Tools | Templates.
        return list; //To change body of generated methods, choose Tools | Templates.
    }
}
