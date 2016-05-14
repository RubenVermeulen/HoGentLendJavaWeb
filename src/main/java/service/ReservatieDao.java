package service;

import domain.Reservatie;
import domain.ReservatieLijn;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alexa
 */
public interface ReservatieDao extends GenericDao<Reservatie> {

    public List<Reservatie> getAllReservaties();
    public List<Reservatie> getAllReservatiesStartingFrom(Date startingDate);
    public List<Reservatie> getReservationsByDates(LocalDateTime ophaalmoment, LocalDateTime indienmoment);

}