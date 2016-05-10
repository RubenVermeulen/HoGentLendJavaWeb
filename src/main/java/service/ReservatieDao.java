/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Reservatie;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author alexa
 */
public interface ReservatieDao extends GenericDao<Reservatie> {

    public List<Reservatie> getReservationsByDates(LocalDateTime ophaalmoment, LocalDateTime indienmoment);

}
