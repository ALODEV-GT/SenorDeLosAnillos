package clases;

public class Orco extends Bestia {
    private static final String NOMBRE = "ORCO ";
    private static final int VIDA_INICIAL = 300;
    private static int contador = 1;

    public Orco() {
        super(NOMBRE + contador++, VIDA_INICIAL);
    }

    @Override
    public void atacar(Luchador enemigo) {
        int danio = Bestia.generarAtaque();
        final double REDUCCION_ARMADURA = 0.1;
        int armaduraEnemigo = (int) (enemigo.getArmadura() * (1 - REDUCCION_ARMADURA));

        if (danio > armaduraEnemigo) {
            System.out.print("\u001B[31m-------- REDUCI TU ARMADURA ---------------->\u001B[0m");
            danio -= armaduraEnemigo;
            enemigo.setVida(danio);
        }
        System.out.println();
    }

}
