/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface AbstractService<T> {
     long save(T obj);
    void delete(long id);
    void update(T obj,long id);
    ArrayList<T> getAll();
    T getById(long id); 
}
