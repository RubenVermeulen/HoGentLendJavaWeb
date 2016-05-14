package domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
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
import static org.aspectj.lang.reflect.DeclareAnnotation.Kind.Type;
import static org.aspectj.weaver.loadtime.definition.Definition.DeclareAnnotationKind.Type;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "reservaties")
@NamedQueries({
    @NamedQuery(name = "Reservatie.getAllReservaties", query = "SELECT r FROM Reservatie r")
})
public class Reservatie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
//    @ManyToOne
//    @JoinColumn(name = "lener_id")
//    private Gebruiker lener;

    // Date in plaats van LocalDateTime omdat Java EE nog maar aan versie 7 zit.
    private Date ophaalmoment;
    private Date indienmoment;
    private Date reservatiemoment;

    private boolean opgehaald;

//    @OneToMany(mappedBy = "reservatie", fetch = FetchType.EAGER, orphanRemoval = true)
//    private List<ReservatieLijn> reservatielijen;

    public Reservatie() {
    }

//    public Reservatie(Gebruiker lener, LocalDateTime ophaalmoment, LocalDateTime indienmoment) {
//        this(lener, ophaalmoment, indienmoment, LocalDateTime.now());
//    }

//    public Reservatie(Gebruiker lener, LocalDateTime ophaalmoment, LocalDateTime indienmoment,
//            LocalDateTime reservatiemoment) {
//        this(lener, ophaalmoment, indienmoment, reservatiemoment, false);
//    }
//
//    public Reservatie(Gebruiker lener, LocalDateTime ophaalmoment, LocalDateTime indienmoment,
//            LocalDateTime reservatiemoment, boolean opgehaald) {
//        this.lener = lener;
//        this.ophaalmoment = ophaalmoment;
//        this.indienmoment = indienmoment;
//        setReservatiemoment(reservatiemoment);
//        this.opgehaald = opgehaald;
//    }

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

//    public Gebruiker getLener() {
//        return lener;
//    }
//
//    public void setLener(Gebruiker lener) {
//        this.lener = lener;
//    }

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

//    public List<ReservatieLijn> getReservatielijnen() {
//        return reservatielijen;
//    }
//
//    public void setReservatielijnen(List<ReservatieLijn> reservatielijen) {
//        this.reservatielijen = reservatielijen;
//    }

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