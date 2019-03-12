/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daoImp;

import Dao.LivreDao;
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
public class LivreDaoImp implements LivreDao{
    
    private final String sqlGetAll = "select * from livre order by titre";
    private final String sqlGetById = "select * from livre where id = ? ";
    private final String sqlInsert = "insert into livre(anneeEdition,cote,exemplaire,maisonEdition,titre,auteur)values(?,?,?,?,?,?)";
    private final String sqlDelete = "delete from livre where id = ?";
    private final String sqlUpdate = "update livre set exemplaire = ? where id = ? ";
    private final String sqlSearche = "select * from livre where titre like";
    
    @Override
    public long save(Livre obj) {
        long id = 0;
        Connection c = null;
        PreparedStatement preparedStatement = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c, sqlInsert, false, obj.getAnneeEdition(),obj.getCote(),obj.getExemplaire(),obj.getMaisonEdition(),obj.getTitre(),obj.getAuteur());
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
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c,sqlDelete, false, id);
            int statu = preparedStatement.executeUpdate();
            c.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Livre obj, long id) {
         Connection c = null;
        PreparedStatement preparedStatement = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c,sqlUpdate,false,obj.getExemplaire(), id);
            int statu = preparedStatement.executeUpdate();
            c.close();
        } catch (Exception e) {
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Livre> getAll() {
        ArrayList<Livre> list = new ArrayList<>();
        Connection c = null;
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
        return list;
    }

    @Override
    public Livre getById(long id) {
         Connection c = null;
        PreparedStatement preparedStatement = null;
        Livre livre = null;
        ResultSet resultSet;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement = PrepareState.initialisationRequetePreparee(c, sqlGetById, false, id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                livre = mapping(resultSet);
            c.close();
        } catch (Exception e) {
        } //To change body of generated methods, choose Tools | Templates.
        return livre;
    }
    

    @Override
    public Livre mapping(ResultSet r) {
        Livre l = new Livre();
        try {
            l.setId(r.getLong("id"));
            l.setAnneeEdition(r.getDate("anneeEdition"));
            l.setCote(r.getString("cote"));
            l.setExemplaire(r.getInt("exemplaire"));
            l.setMaisonEdition(r.getString("maisonEdition"));
            l.setTitre(r.getString("titre"));
            l.setAuteur(r.getString("auteur"));
        } catch (SQLException ex) {
            Logger.getLogger(LivreDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
                
    }

    @Override
    public ArrayList<Livre> getSearch(String search) {
       ArrayList<Livre> list = new ArrayList<>();
        Connection c = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            c = daoFactory.DaoFactory.getConnection();
            preparedStatement =c.prepareStatement(sqlSearche+"'"+search+"%'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                list.add(mapping(resultSet));
            }
            c.close();
        } catch (Exception e) {
        }
        return list;
    }
    
    
}
