package clases;

import manejador.MotorJuego;

public class Elfo extends Heroe {
    private static final String NOMBRE = "ELFO ";
    private static final int VIDA_INICIAL = 250;
    private static int contador = 1;

    public Elfo() {
        super(NOMBRE + contador++, VIDA_INICIAL);
    }

    @Override
    public void atacar(Luchador enemigo) {
        int danio = Heroe.generarAtaque();
        final int rabia = MotorJuego.generarNumAleatorio(0, 10);

        if (enemigo instanceof Orco) {
            danio += rabia;
            danio -= enemigo.getArmadura();

            if (danio > enemigo.getArmadura()) {
                enemigo.setVida(danio);
            }
        } else {
            if (danio > enemigo.getArmadura()) {
                danio -= enemigo.getArmadura();
                enemigo.setVida(danio);
            }
        }
    }

}
