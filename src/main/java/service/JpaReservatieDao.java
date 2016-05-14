package service;

import domain.Reservatie;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexa
 */
public class JpaReservatieDao extends GenericDaoJpa<Reservatie> implements ReservatieDao {

    public JpaReservatieDao() {
        super(Reservatie.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservatie> getReservationsByDates(LocalDateTime ophaalmoment, LocalDateTime indienmoment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservatie> getAllReservaties() {
        TypedQuery<Reservatie> q = em.createNamedQuery("Reservatie.getAllReservaties", Reservatie.class);

        return q.getResultList();
    }

}