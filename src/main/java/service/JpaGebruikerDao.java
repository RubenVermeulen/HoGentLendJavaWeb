/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Gebruiker;
import domain.Reservatie;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Xander
 */
public class JpaGebruikerDao extends GenericDaoJpa<Gebruiker> implements GebruikerDao {

    public JpaGebruikerDao() {
        super(Gebruiker.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gebruiker> getAllBeheerders() {
        TypedQuery<Gebruiker> q = em.createNamedQuery("Gebruiker.getAllBeheerders", Gebruiker.class);

        return q.getResultList();
    }
    
}
