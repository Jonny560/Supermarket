import java.time.LocalDate;
/*
 * Begründung siehe Ware.java
 */
public class Wein extends Ware{
    LocalDate temp; 
    static int counter;
    public Wein(String bezeichnung, int qualitaet, String verfallsDatum, double preis, String herstellungsDatum, String einlagerungsDatum) {
        super(bezeichnung, qualitaet, verfallsDatum, preis, herstellungsDatum, einlagerungsDatum);
        setVerfallsDatum();
        setEntsorgenNein();
        temp = datum;
    }

    // Weine dürfen keine negativen Qualitätswerte haben
    public void pruefeWeinQualitaet() {
        if (this.qualitaet < 0) {
            System.out.println("Weine dürfen keine negative qualität besitzen.");
            this.setQualitaet(50);
        }
    }

    // nächsten Tag simulieren
    public Ware simuliereNaechstenTag(LocalDate heute) {
        if (datum.isAfter(verfallsDatum) == true) {
            setEntsorgenJa();
        }
        datum = heute.plusDays(1); 
        pruefeTage();
        counter++;
        setPreis(Math.round(berechneTagesPreis()));
        return this;
    }

    // Weine bekommen alle 10 Tage einen Qualitätspunkt
    public void pruefeTage() {
        if (counter == 9 ) {
            this.qualitaet += 1; 
            counter = 0;
        }
    }

    // Weine verfallen nicht 
    public void setVerfallsDatum () {
        System.out.println("Weine haben kein Verfallsdatum.");
        this.verfallsDatum = LocalDate.parse("9999-12-31");
    }
    // Weine verändern ihre preise nicht, nachdem sie eingerämt wurden
}