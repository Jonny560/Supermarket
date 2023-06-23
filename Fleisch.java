/*
 * Fleisch muss binnen 7 Tagen nach Einlagerung verkauft werden --> Das Verfallsdatum ist immmer eine Woche nach der Einlagerung
 * Nach 5 Tagen wird das Fleisch um 50% reduziert
 * Nach einem weiteren Tag wird das Produkt um weitere 50% reduzierzt 
 */

import java.time.LocalDate;

public class Fleisch extends Ware{
    
    public Fleisch(String bezeichnung, int qualitaet, String verfallsDatum, double preis, String herstellungsDatum, String einlagerungsDatum) {
        super(bezeichnung, qualitaet, verfallsDatum, preis, herstellungsDatum, einlagerungsDatum);
        setEntsorgenNein();
        setVerfallsDatum(this.einlagerungsDatum.plusDays(7));
    }

    public void berechnePreis() {
        long diff = berechneTagesDifferenz(einlagerungsDatum, datum);
        if (diff < 0) {
            diff = diff * -1; 
        }
        if (diff == 5) {
            this.preis = this.preis * 0.5; 
        }
        if (diff == 6) {
            this.preis = this.preis * 0.5;
        }
    }

     public Ware simuliereNaechstenTag(LocalDate heute) {
        if (datum.isAfter(verfallsDatum) == true) {
            setEntsorgenJa();
        }
        datum = heute.plusDays(1); 
        berechnePreis();
        return this;
    }


}
