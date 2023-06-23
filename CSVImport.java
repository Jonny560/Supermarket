import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * Klasse für den Import von Warendaten aus einer CSV datei
 * Die Datei muss im Format ( Bezeichnung, Qualität, Verfallsdatum, Preis, Herstellungsdatum, Einlagerungsdatum) sein 
 */

public class CSVImport extends Imports {
    
    String trenner = ",";
    String zeile; 
    int k = 0;
    Ware[] warenLager;
    BufferedReader br;
    

    public CSVImport(String pfad) throws IOException {
        br = Files.newBufferedReader(Paths.get(pfad));
        this.pfad = pfad;
    }

    @Override
    public Ware[] leseImport() throws IOException {
        while ((zeile = br.readLine()) != null) {
            String[] spalte = zeile.split(trenner);
            for (int i = 0; i < spalte.length; i++) {
                Ware ware = new Ware(spalte[i], Integer.parseInt(spalte[i + 1]), spalte[i + 2], Integer.parseInt(spalte[i + 3]), spalte[i + 4], spalte[i + 5]);
                warenLager[k] = ware;
                break;
            }
            k++;
        }
        return warenLager;
    }
}


