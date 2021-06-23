package clases;

import manejador.MotorJuego;

public abstract class Heroe extends Luchador {

    public Heroe(String nombre, int vida) {
        super(nombre, vida);
    }

    @Override
    public void atacar(Luchador enemigo) {
        int danio = Heroe.generarAtaque();

        if (danio > enemigo.getArmadura()) {
            danio -= enemigo.getArmadura();
            enemigo.setVida(danio);
        }
        System.out.println();
    }

    public static int generarAtaque() {
        int dado1 = MotorJuego.generarNumAleatorio(0, 100);
        int dado2 = MotorJuego.generarNumAleatorio(0, 100);
        int danio = dado1 > dado2 ? dado1 : dado2;
        return danio;
    }
}
