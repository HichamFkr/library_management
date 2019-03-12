/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.User;

/**
 *
 * @author ASUS
 */
public interface UserDao extends AbstractDao<User>{
   User  getByLogin(String email,String motpass);
}
