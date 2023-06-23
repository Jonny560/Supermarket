import java.io.IOException;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) throws IOException {
        int i;
        String pfad = "Pfad zur CSV Datei"; // Pfad für CSV Import
        String befehl = "psql -U username -d dbname -h serverhost -f scripfile.sql"; // Befehl für SQL Import
        boolean vergl = false;
        LocalDate zukunftsDatum = LocalDate.parse("2023-07-14");
        LocalDate datumHeute = LocalDate.parse("2023-06-23");
        Ware brot = new Ware("Bauernbrot        ", 50, "2023-06-30", 2.99, "2023-06-05", "2023-06-18");
        Ware kaese = new Kaese("Camambert         ", 48, "2023-08-25", 8.50, "2023-06-11", "2023-06-18");
        Ware muesli = new Ware("Müsli             ", 80, "2024-03-31", 4.50, "2023-02-06", "2023-06-18");
        Ware wein = new Wein("Cabernet Sauvignon", 90, "2023-06-30", 20.00, "2014-09-15", "2023-06-18");
        Ware aepfel = new Ware("Gramnny Smith     ", 50, "2023-08-11", 6.99, "2023-06-18", "2023-06-18");
        Ware[] warenLager = new Ware[5]; 
        warenLager[0] = brot;
        warenLager[1] = kaese; 
        warenLager[2] = muesli;
        warenLager[3] = wein; 
        warenLager[4] = aepfel;
        CSVImport CSVImport = new CSVImport(pfad);
        SQLImport SQLImport = new SQLImport(befehl);
        Fleisch rind = new Fleisch("Rinderrippen     ", 70, "2023-08-30", 15.99, "2023-06-20", "2023-06-23");
        Ware[] fleischLager = new Ware[1]; 
        fleischLager[0] = rind;

        // Ausgabe der vorgefertigten Daten
        while (vergl == false) {
            vergl = datumHeute.isEqual(zukunftsDatum);
            System.out.println("Datum: " + datumHeute);
            for (i = 0; i < warenLager.length; i++) {
                warenLager[i].datum = datumHeute;
                ausgabe(warenLager[i]);
                warenLager[i] = warenLager[i].simuliereNaechstenTag(warenLager[i].datum);
            }
            System.out.println("");
            datumHeute = datumHeute.plusDays(1);
            i = 0;
        }  

        // Ausgabe des CSV imports
        Ware[] warenLagerCSV = CSVImport.leseImport();

        if (warenLagerCSV != null) {
            for (int j = 0; j < warenLagerCSV.length; j++) {
            ausgabe(warenLagerCSV[j]);
            }
        }

        // Ausgabe des SQL Imports
        Ware[] warenLagerSQL = SQLImport.leseImport();
        
        if (warenLagerSQL != null) {
            for (int l = 0; l < warenLagerSQL.length; l++) {
            ausgabe(warenLagerSQL[l]);
            }
        }

        // Ausgabe der neuen Produktart
        zukunftsDatum = LocalDate.parse("2023-07-02");
        datumHeute = LocalDate.parse("2023-06-23");
        vergl = false; 

        while (vergl == false) {
        vergl = datumHeute.isEqual(zukunftsDatum);
        System.out.println("Datum: " + datumHeute);
        for (i = 0; i < fleischLager.length; i++) {
                fleischLager[i].datum = datumHeute;
                ausgabe(fleischLager[i]);
                fleischLager[i] = fleischLager[i].simuliereNaechstenTag(fleischLager[i].datum);
            }
            System.out.println("");
            datumHeute = datumHeute.plusDays(1);
            i = 0;
        }

    }

    public static void ausgabe(Ware ware) {
        System.out.println("Ware " + ware.toString());
    }

}