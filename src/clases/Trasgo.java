package clases;

public class Trasgo extends Bestia {
    private static final String NOMBRE = "TRASGO ";
    private static final int VIDA_INICIAL = 325;
    private static int contador = 1;

    public Trasgo() {
        super(NOMBRE + contador++, VIDA_INICIAL);
    }
}
