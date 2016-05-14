package service;

import domain.Reservatie;
import domain.ReservatieLijn;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

public class JpaReservatieLijnDao  extends GenericDaoJpa<ReservatieLijn> implements ReservatieLijnDao {

    public JpaReservatieLijnDao() {
        super(ReservatieLijn.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservatieLijn> getAllReservatieLijnen() {
        TypedQuery<ReservatieLijn> q = em.createNamedQuery("ReservatieLijn.getAllReservatieLijnen", ReservatieLijn.class);

        return q.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservatieLijn> getAllReservatieLijnenStartingFrom(Date startingDate) {
        TypedQuery<ReservatieLijn> q = em.createNamedQuery("ReservatieLijn.getAllReservatieLijnenStartingFrom", ReservatieLijn.class);

        q.setParameter("startingDate", startingDate);
        
        return q.getResultList();
    }



}
