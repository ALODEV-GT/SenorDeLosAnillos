package clases;

import manejador.MotorJuego;

public abstract class Bestia extends Luchador {

    public Bestia(String nombre, int vida) {
        super(nombre, vida);
    }

    @Override
    public void atacar(Luchador enemigo) {
        int danio = Bestia.generarAtaque();

        if (danio > enemigo.getArmadura()) {
            danio -= enemigo.getArmadura();
            enemigo.setVida(danio);
        }
        System.out.println();
    }

    public static int generarAtaque() {
        int danio = MotorJuego.generarNumAleatorio(0, 90);
        return danio;
    }

}
