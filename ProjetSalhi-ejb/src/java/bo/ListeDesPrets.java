/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 *
 * @author ASUS
 */
@Entity
public class ListeDesPrets implements Serializable{
    
    @Id 
    private long id;
    private Etudient etudient;
    private Livre livre;
    private boolean isRetourne;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Etudient getEtudient() {
        return etudient;
    }

    public void setEtudient(Etudient etudient) {
        this.etudient = etudient;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public boolean getIsRetourne() {
        return isRetourne;
    }

    public void setIsRetourne(boolean isRetourne) {
        this.isRetourne = isRetourne;
    }
    
}
