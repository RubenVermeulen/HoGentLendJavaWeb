package service;

import domain.Gebruiker;
import java.util.List;


public interface GebruikerDao extends GenericDao<Gebruiker> {

    public List<Gebruiker> getAllBeheerders();

}