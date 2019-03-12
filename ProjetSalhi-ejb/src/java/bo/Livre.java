/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ASUS
 */
@Entity
public class Livre implements Serializable{
    @Id
    private long id;
    private String cote;
    private String titre;
    private String maisonEdition;
    private Date anneeEdition;
    private int exemplaire;
    private String auteur;

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public String getCote() {
        return cote;
    }

    public void setCote(String cote) {
        this.cote = cote;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(String maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    public Date getAnneeEdition() {
        return anneeEdition;
    }

    public void setAnneeEdition(Date anneeEdition) {
        this.anneeEdition = anneeEdition;
    }

    public int getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(int exemplaire) {
        this.exemplaire = exemplaire;
    }
    
    
    
    
}
