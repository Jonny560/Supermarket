import java.io.IOException;

/*
 * Für die verschiedenen sorten von Imports habe ich eine abstrakte klasse erstellt, damit in zukunft weitere Importarten leiter erstellt werden können
 */

public abstract class Imports {
    protected String pfad; 
    public abstract Ware[] leseImport() throws IOException; 
}
