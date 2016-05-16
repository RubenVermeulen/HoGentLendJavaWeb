package bean;
public class FilterData {
    
    private String soortLijst = "gereserveerde";
    private String datum;

    public String getSoortLijst() {
        return soortLijst;
    }

    public void setSoortLijst(String soortLijst) {
        this.soortLijst = soortLijst;
    }
    
    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "FilterData{" + "soortLijst=" + soortLijst + ", datum=" + datum + '}';
    }
}
