package service;

import domain.Reservatie;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author alexa
 */
public interface ReservatieDao extends GenericDao<Reservatie> {

    public List<Reservatie> getAllReservaties();
    public List<Reservatie> getReservationsByDates(LocalDateTime ophaalmoment, LocalDateTime indienmoment);

}