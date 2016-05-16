/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "gebruikers")
@NamedQueries({
    @NamedQuery(name = "Gebruiker.getAllBeheerders", query = "SELECT g FROM Gebruiker g WHERE g.is_beheerder = 1")
})
public class Gebruiker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String voornaam;
    private String achternaam;
    private String email;
    
    @Column(columnDefinition = "BIT", length = 1)
    private boolean is_beheerder;
   // private String paswoord;
    //private boolean hoofdbeheerder;
    // private boolean beheerder;
    //private boolean lector;

    protected Gebruiker() {
        // default constructor for jpa
    }

    protected long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    protected void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    protected void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    protected final void setEmail(String email) {
        if (email != null) {
            email = email.toLowerCase();
        }
        this.email = email;
    }

//    protected String getPaswoord() {
//        return paswoord;
//    }

//    public boolean isHoofdbeheerder() {
//        return hoofdbeheerder;
//    }
//
//    protected void setHoofdbeheerder(boolean hoofdbeheerder) {
//        this.hoofdbeheerder = hoofdbeheerder;
//    }

//    public boolean isBeheerder() {
//        return beheerder;
//    }
//
//    protected void setBeheerder(boolean beheerder) {
//        this.beheerder = beheerder;
//    }
//    public boolean isLector() {
//        return lector;
//    }
//
//    public void setLector(boolean lector) {
//        this.lector = lector;
//    }

//    @Override
//    public String toString() {
//        return "Gebruiker{" + "id=" + id + ", voornaam=" + voornaam + ", achternaam=" + achternaam + ", email=" + email + ", paswoord=" + paswoord + ", hoofdbeheerder=" + hoofdbeheerder + ", beheerder=" + beheerder + ", lector=" + lector + '}';
//    }
    public boolean containsFilter(String filter) {
        if (filter == null || filter.isEmpty()) {
            return true;
        }
        return hasFilter(email, filter) || hasFilter(voornaam, filter) || hasFilter(achternaam, filter);
    }

    private boolean hasFilter(String string, String filter) {
        return string != null && string.toLowerCase().contains(filter.toLowerCase());
    }

}
