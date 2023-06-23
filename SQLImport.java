import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SQLImport extends Imports {
    Ware[] warenLager; 
    String trenner = " ";
    int k = 0; 
    String befehl; 
    public SQLImport (String befehl) {
        this.befehl = befehl;
    }

     @Override
    public Ware[] leseImport() throws IOException {
        
        String zeile;
        Process p = Runtime.getRuntime().exec("psql -U username -d dbname -h serverhost -f scripfile.sql");
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((zeile = input.readLine()) != null) {
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
