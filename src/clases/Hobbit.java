package clases;

public class Hobbit extends Heroe {
    private static final String NOMBRE = "HOBBIT ";
    private static final int VIDA_INICIAL = 200;
    private static int contador = 1;

    public Hobbit() {
        super(NOMBRE + contador++, VIDA_INICIAL);
    }

    @Override
    public void atacar(Luchador enemigo) {
        int danio = Heroe.generarAtaque();
        final int miedo = 5;

        if (enemigo instanceof Trasgo) {
            danio -= miedo;

            if (danio > enemigo.getArmadura()) {
                System.out.print(" ----------- LE TEMO A LOS TRASGOS (-MIEDO) ---------->");
                danio -= enemigo.getArmadura();
                enemigo.setVida(danio - miedo);
            }
        } else {
            if (danio > enemigo.getArmadura()) {
                danio -= enemigo.getArmadura();
                enemigo.setVida(danio);
            }
        }
        System.out.println();
    }
}
