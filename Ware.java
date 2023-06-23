import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * Für die Erstellung des Programmes habe ich eine Vererbungshirarchie verwendet. 
 * Der Grund für die Vererbungshirarchie ist, dass Käse und Wein weiterhin die selben Funktionen beibehalten sollten wie alle anderen Waren, aber dazu noch ihre eigebnen Funktionen haben bzw. Standardfunktionen erweitern.
 * Es ist zudem einfacher weitere Produktarten hinzuzufügen ohne das Programm grundlegend zu ändern
 */

public class Ware {
    String bezeichnung;
    String beschreibung;
    String entsorgen;
    int qualitaet; 
    int jahr; 
    int monat; 
    int tag; 
    LocalDate datum; 
    LocalDate einlagerungsDatum;
    LocalDate herstellungsDatum;
    LocalDate verfallsDatum;
    double preis;
    double tagesPreis; 

    public Ware (String bezeichnung, int qualitaet, String verfallsDatum, double preis, String herstellungsDatum, String einlagerungsDatum) {
        this.bezeichnung = bezeichnung; 
        this.qualitaet = qualitaet; 
        this.verfallsDatum = LocalDate.parse(verfallsDatum); 
        this.preis = preis; 
        this.einlagerungsDatum = LocalDate.parse(einlagerungsDatum);
        setDatumToHeute();
        setHerstellungsDatum(herstellungsDatum);
        setEntsorgenNein();
        
    }

    // Differenz zwischen zwei Tagen berechnen
    public long berechneTagesDifferenz(LocalDate datum1, LocalDate datum2) {
        long tageDazwischen; 
        tageDazwischen = ChronoUnit.DAYS.between(datum1, datum2);  
        if(tageDazwischen > 0) {
            return tageDazwischen;
        }
        else {
            return tageDazwischen * -1;
        }
    }

    // Nächsten Tag simulieren
    public Ware simuliereNaechstenTag(LocalDate heute) {
        if (datum.isAfter(verfallsDatum) == true) {
            setEntsorgenJa();
        }
        datum = heute.plusDays(1); 
        setPreis(Math.round(berechneTagesPreis()));
        return this;
    }

    // Ausgabemethode des Objektes Ware
    @Override
    public String toString() {
        beschreibung = "Name: " + bezeichnung  + " Qualität: " + qualitaet  + " Verfallsdatum: " + verfallsDatum + " Preis: " + preis + "  Produkt entsorgen: " + entsorgen + " Einlagerungsdatum: " + einlagerungsDatum + " Datum: " + datum;  
        return beschreibung;
    }
    
    // Entsorgen auf "ja" setzen
    public void setEntsorgenJa() {
        this.entsorgen = "ja";
    }

    // Entsorgen auf "nein" setzen
    public void setEntsorgenNein() {
        this.entsorgen = "nein";
    }

    // Tagespreis berechnen
    public double berechneTagesPreis() {      
        return this.preis + 0.1 * this.qualitaet; 
    }
    
    // Getter und Setter
    public void setVerfallsDatum (String datum) {
        this.verfallsDatum = LocalDate.parse(datum);
    }

    public void setDatumToHeute() {
        this.datum = LocalDate.now();
    }

    public void setHerstellungsDatum(String datum) {
        this.herstellungsDatum = LocalDate.parse(datum);
    }

    public void einraeumen() {
        this.preis = berechneTagesPreis();
    }

    public boolean kaeseVerfallen() {
        return false;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getEntsorgen() {
        return entsorgen;
    }

    public void setEntsorgen(String entsorgen) {
        this.entsorgen = entsorgen;
    }

    public int getQualitaet() {
        return qualitaet;
    }

    public void setQualitaet(int qualitaet) {
        this.qualitaet = qualitaet;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public int getMonat() {
        return monat;
    }

    public void setMonat(int monat) {
        this.monat = monat;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalDate getEinlagerungsDatum() {
        return einlagerungsDatum;
    }

    public void setEinlagerungsDatum(LocalDate einlagerungsDatum) {
        this.einlagerungsDatum = einlagerungsDatum;
    }

    public LocalDate getHerstellungsDatum() {
        return herstellungsDatum;
    }

    public void setHerstellungsDatum(LocalDate herstellungsDatum) {
        this.herstellungsDatum = herstellungsDatum;
    }

    public LocalDate getVerfallsDatum() {
        return verfallsDatum;
    }

    public void setVerfallsDatum(LocalDate verfallsDatum) {
        this.verfallsDatum = verfallsDatum;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public double getTagesPreis() {
        return tagesPreis;
    }

    public void setTagesPreis(double tagesPreis) {
        this.tagesPreis = tagesPreis;
    }

    public boolean zumWegraeumen() {
        return false;
    }
}


