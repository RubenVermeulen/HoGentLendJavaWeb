package domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "reservatie_lijn")
@NamedQueries({
    @NamedQuery(name = "ReservatieLijn.getAllReservaties", query = "SELECT r FROM ReservatieLijn r"),
    @NamedQuery(name = "Reservatie.getAllReservatieLijnenStartingFrom", query = "SELECT r FROM ReservatieLijn r WHERE r.ophaalmoment <= :startingDate AND r.reservatie.opgehaald = 0")
})
public class ReservatieLijn implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date ophaalmoment;
    private Date indienmoment;

    @ManyToOne
    private Materiaal materiaal;
    private int aantal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Reservatie reservatie;

    public ReservatieLijn() {
    }

//    public ReservatieLijn(Materiaal materiaal, int aantal, LocalDateTime ophaalmoment, LocalDateTime indienmoment) {
//        this.ophaalmoment = ophaalmoment;
//        this.indienmoment = indienmoment;
//        this.materiaal = materiaal;
//        this.aantal = aantal;
////        materiaal.setAantalOnbeschikbaar(materiaal.getAantalOnbeschikbaar()+aantal);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Materiaal getMateriaal() {
        return materiaal;
    }

    public void setMateriaal(Materiaal materiaal) {
        this.materiaal = materiaal;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public Reservatie getReservatie() {
        if (reservatie == null) {
            System.out.println("Sven had gelijk xp");
        }
        return reservatie;
    }

    public void setReservatie(Reservatie reservatie) {
        this.reservatie = reservatie;
    }

//    public boolean containsFilter(String sFilter, LocalDateTime dtOphaal, LocalDateTime dtIndien) {
//
//        boolean filterDatum = MyDateUtil.doesFirstPairOverlapWithSecond(dtOphaal, dtIndien, ophaalmoment, indienmoment);
//
//        boolean materiaalFilter = materiaal.containsFilter(sFilter);
//        boolean materiaalFilterMatters = (sFilter != null && !sFilter.trim().isEmpty()) || (dtOphaal == null && dtIndien == null);
//
//        if (materiaalFilterMatters) {
//            if (dtOphaal == null && dtIndien == null) {
//                return filterDatum || materiaalFilter;
//            } else {
//                return filterDatum && materiaalFilter;
//            }
//        } else {
//            return filterDatum;
//        }
//    }
}
