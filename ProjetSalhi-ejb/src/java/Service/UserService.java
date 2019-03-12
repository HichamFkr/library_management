/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import bo.User;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface UserService extends AbstractService<User>{
    User  getByLogin(String email,String motpass);
}
