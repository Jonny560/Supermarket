
/* import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {
    

    Ware testWare1 = new Ware("Test", 30, "2023-07-30", 5.00, "3023-05-15", "2023-06-01");
    Ware testWare2 = new Kaese("Test", 29, "2023-07-30", 5.00, "3023-05-15", "2023-06-01");
    Ware testWare3;
    Wein testWare5 = new Wein("Test", 40, "2023-07-30", 5.00, "3023-05-15", "2023-07-18");

    public void testeGrundPreis() {
        // Jedes Produkt soll einen Fixen nicht Variablen Preis haben 

    }

    @Test
    public void testeTagesPreis() {
        // Tagespreis = Grundpreis + 0,10€ * Qualität
        double tagesPreisSoll = testWare1.preis + 0.1 * testWare1.qualitaet;
        double tagesPreisIst = testWare1.berechneTagesPreis();
        Assert.assertEquals(tagesPreisSoll, tagesPreisIst);
    }

    @Test
    public void testeminKaeseNiveau() {
        // Käse brauch ein minimales Qualitätsniveau von 30 und wird ausgeräumt sobald die Qualität unter 30 sinkt
        boolean test = testWare2.zumWegraeumen();
        Assert.assertEquals(true, test);
    }

    @Test
    public void testeVerfallsDatumKaese() {
        // Verfallsdatum soll zwischen 50 und 100 Tagen in der zukunft liegen
        boolean test = testWare2.kaeseVerfallen();
        Assert.assertEquals(false, test);
    }

    @Test
    public void testeQualitaetsVerlust() {
        // Käse verliert Täglich einen Qualitätspunkt
        testWare3 = testWare2.simuliereNaechstenTag(LocalDate.now());
        Assert.assertEquals(testWare3.getQualitaet(), testWare2.getQualitaet() + 1);
    }

    @Test
    public void testeTagesaktuellenPreis() {
        // Käse hat einen Tagesaktuellen Preis
        double tagesPreisSoll = testWare2.preis + 0.1 * testWare1.qualitaet;
        double tagesPreisIst = testWare2.berechneTagesPreis();
        Assert.assertEquals(tagesPreisSoll, tagesPreisIst);
    }

    @Test
    public void testeQualitaetNegWein() {
        // Wein darf keine negativen Qualitätsniveaus akzeptieren
        Wein testWare4 = new Wein("Test", -1, "2023-07-30", 5.00, "3023-05-15", "2023-06-01");
    }

    @Test
    public void testezunehmendeQualitaet() {
        // Weine gewinnen jede 10 Tage 1 Qualitätspunkt
        Wein testWare6 = testWare5;
        testWare5.pruefeTage();
        Assert.assertEquals(testWare6.getQualitaet(), testWare5.getQualitaet() - 1);
    }

    @Test
    public void testeWeinVerfall() {
        // Weine verfallen nicht
        Wein testWare7 = new Wein("Test", 50, "2023-07-30", 5.00, "3023-05-15", "2023-06-01");
    }

    @Test
    public void testeWeinPreis() {
        // Weine verändern ihre Preise nicht 
    }



} */
