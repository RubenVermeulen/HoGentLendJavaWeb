package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groepen")
public class Groep implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String groep;
    
    // Nodig voor hibernate
    @Column(name="isleergroep", columnDefinition = "BIT", length = 1)
    private boolean isLeerGebied;

    protected Groep() {
        // default constructor for jpa
    }

//    public Groep(String groep, boolean isLeerGebied) {
//        setIsLeerGebied(isLeerGroep);
//        setGroep(groep);
//    }

    public String getGroep() {
        return groep;
    }

    public final void setGroep(String groep) {
        if (groep == null || groep.trim().isEmpty()) {
            throw new IllegalArgumentException("De naam is niet ingevuld.");
        }
        this.groep = groep;
    }

    public final boolean isLeerGroep() {
        return isLeerGebied;
    }

    public void setIsLeerGebied(boolean isLeerGebied) {
        this.isLeerGebied = isLeerGebied;
    }

    public long getId() {
        return id;
    }

    public boolean containsFilter(String filter) {
        if (filter == null || filter.isEmpty()) {
            return true;
        }
        return hasFilter(groep, filter);
    }

    private boolean hasFilter(String string, String filter) {
        return string != null && string.toLowerCase().contains(filter.toLowerCase());
    }
}
