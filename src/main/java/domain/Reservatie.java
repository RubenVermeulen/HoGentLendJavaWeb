package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "reservaties")
@NamedQueries({
    @NamedQuery(name = "Reservatie.getAllReservaties", query = "SELECT r FROM Reservatie r"),
    @NamedQuery(name = "Reservatie.getAllReservatiesStartingFrom", query = "SELECT r "
            + "FROM Reservatie r WHERE r.ophaalmoment >= :startingDate"),
    @NamedQuery(name = "Reservatie.getAllReservatiesOpgehaald", query = "SELECT r FROM Reservatie r WHERE r.opgehaald = 1"),
    @NamedQuery(name = "Reservatie.getAllReservatiesOpgehaaldStartingFrom", query = "SELECT r FROM Reservatie r WHERE r.opgehaald = 1 AND  r.ophaalmoment <= :startingDate ")     
        
})
public class Reservatie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "lener_id")
    private Gebruiker lener;

    // Date in plaats van LocalDateTime omdat Java EE nog maar aan versie 7 zit.
    private Date ophaalmoment;
    private Date indienmoment;
    private Date reservatiemoment;

    // Nodig voor hibernate
    @Column(columnDefinition = "BIT", length = 1)
    private boolean opgehaald;

    @OneToMany(mappedBy = "reservatie", fetch = FetchType.EAGER, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<ReservatieLijn> reservatielijnen;

    public Reservatie() {
    }

//    public boolean containsFilter(String sFilter, LocalDateTime dtOphaal, LocalDateTime dtIndien) {
//        boolean filterInLijnen = false;
//        for (ReservatieLijn l : reservatielijen) {
//            filterInLijnen = l.containsFilter(sFilter, dtOphaal, dtIndien);
//            if (filterInLijnen) {
//                break;
//            }
//        }
//
//        boolean filterInLener = lener.containsFilter(sFilter);
//
//        boolean lenerFiltersMatter = (sFilter != null && !sFilter.trim().isEmpty()) || (dtOphaal == null && dtIndien == null);
//
//        boolean filterDatum = MyDateUtil.doesFirstPairOverlapWithSecond(dtOphaal, dtIndien, ophaalmoment, indienmoment);
//
//        if (lenerFiltersMatter) {
//            if (dtOphaal == null && dtIndien == null) {
//                return filterDatum || filterInLijnen || filterInLener;
//            } else {
//                return (filterDatum && filterInLener) || filterInLijnen;
//            }
//        } else {
//            return filterDatum || filterInLijnen;
//        }
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gebruiker getLener() {
        return lener;
    }

    public void setLener(Gebruiker lener) {
        this.lener = lener;
    }

    public Date getOphaalmoment() {
        return ophaalmoment;
    }

    public void setOphaalmoment(Date ophaalmoment) {
        this.ophaalmoment = ophaalmoment;
    }

    public Date getIndienmoment() {
        return indienmoment;
    }

    public void setIndienmoment(Date indienmoment) {
        this.indienmoment = indienmoment;
    }

    public List<ReservatieLijn> getReservatielijnen() {
        return reservatielijnen;
    }

    public void setReservatielijnen(List<ReservatieLijn> reservatielijen) {
        this.reservatielijnen = reservatielijen;
    }

    public Date getReservatiemoment() {
        return reservatiemoment;
    }

    private void setReservatiemoment(Date reservatiemoment) {
        this.reservatiemoment = reservatiemoment;
    }

    public boolean isOpgehaald() {
        return opgehaald;
    }

    public void setOpgehaald(boolean opgehaald) {
        this.opgehaald = opgehaald;
    }
}