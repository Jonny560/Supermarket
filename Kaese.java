import java.time.LocalDate;
/*
 * Begründung siehe Ware.java
 */
public class Kaese extends Ware{

    public Kaese(String bezeichnung, int qualitaet, String verfallsDatum, double preis, String herstellungssDatum, String einlagerungsDatum) {
        super(bezeichnung, qualitaet, verfallsDatum, preis, herstellungssDatum, einlagerungsDatum);
        setEntsorgenNein();
    }

    // Käse benötigt ein minimales Qualitätsniveau von 30
    public boolean zumWegraeumen() {
        if (this.qualitaet < 30) {
            setEntsorgenJa();
            return true;
        }
        return false; 
    }

    // Käse hat ein Verfallsdatum das zwischen 50 und 100 Tagen in der Zukunft liegt
    @Override
    public boolean kaeseVerfallen() {
        long tageBisVerfall = this.berechneTagesDifferenz(this.herstellungsDatum, this.verfallsDatum);
        if(tageBisVerfall <= 100 || tageBisVerfall >= 50) {
            setEntsorgenNein();
            return true;
        }
        setEntsorgenJa();
        return false;
    }

    // Käse verliert täglich einen Qualitätspunkt
    // Käse hat einen Tagesaktuellen Preis
    public Ware simuliereNaechstenTag(LocalDate heute) {
        if (datum.isAfter(verfallsDatum) == true) {
            setEntsorgenJa();
        }
        datum = heute.plusDays(1); 
        this.qualitaet = this.qualitaet - 1; 
        setPreis(Math.round(berechneTagesPreis()));
        kaeseVerfallen();
        zumWegraeumen();
        return this;
    }
    
}
