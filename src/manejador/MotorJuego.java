package manejador;

import clases.*;

public class MotorJuego {

    private Luchador[] heroes = new Luchador[5];
    private Luchador[] bestias = new Luchador[5];
    private boolean finDelJuego = false;
    private boolean ganaronBestias;

    public MotorJuego() {

    }

    public void iniciarBatalla() {
        generarEquipos();
        mostrarEquipos();

        System.out.println("\n---------- EMPIEZA LA BATALLA ----------");
        do {
            batallar();
            establecerGanador();
            if (finDelJuego) {
                break;
            }
            reordenarFormacion(heroes);
            reordenarFormacion(bestias);
            mostrarEquipos();
            System.out.println("----------------------------------------------------------");
        } while (!finDelJuego);

        if (ganaronBestias) {
            System.out.println("\n\n-X-X-X-X- GANARON LAS BESTIAS -X-X-X-X-");
        } else {
            System.out.println("\n\n~#~#~#~#~ GANARON LOS HEROES ~#~#~#~#~");
        }

        System.out.println("\nSobrevivientes:");
        mostrarEquipos();
    }

    public void mostrarEquipos() {

        System.out.println("\n------ BESTIAS -------");
        for (Luchador b : bestias) {
            if (b != null) {
                System.out.println(b);
            }
        }

        System.out.println("\n------ HEROES -------");

        for (Luchador h : heroes) {
            if (h != null) {
                System.out.println(h);
            }
        }

        System.out.println();
    }

    public void eliminarMuertos(Luchador[] ejercito) {

        for (int i = 0; i < ejercito.length; i++) {
            if (ejercito[i] != null) {
                if (!ejercito[i].estaVivo()) {
                    System.out.println("\u001B[41m☠☠☠ Ha muerto " + ejercito[i].getNombre() + " ☠☠☠\u001B[0m");
                    ejercito[i] = null;
                }
            }
        }

    }

    public void establecerGanador() {
        int contadorMuertosH = 0;
        int contadorMuertosB = 0;

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == null) {
                contadorMuertosH++;
            }
        }

        for (int i = 0; i < bestias.length; i++) {
            if (bestias[i] == null) {
                contadorMuertosB++;
            }
        }

        if (contadorMuertosB == bestias.length || contadorMuertosH == heroes.length) {
            this.finDelJuego = true;
            if (contadorMuertosB == bestias.length) {
                this.ganaronBestias = false;
            } else {
                this.ganaronBestias = true;
            }
        }
    }

    public void reordenarFormacion(Luchador[] formacion) {
        int posicionDisponible = -1;

        for (int i = 0; i < formacion.length; i++) {
            if (formacion[i] == null && posicionDisponible == -1) {
                posicionDisponible = i;
            }
            if (formacion[i] != null && posicionDisponible != -1) {
                formacion[posicionDisponible] = formacion[i];
                formacion[i] = null;
                posicionDisponible = -1;
            }
        }
    }

    public void batallar() {
        int iniciador = MotorJuego.generarNumAleatorio(1, 2);
        if (iniciador == 1) {
            ataqueHeroesABestias();
            eliminarMuertos(bestias);
            ataqueBestiasAHeroes();
            eliminarMuertos(heroes);
        } else {
            ataqueBestiasAHeroes();
            eliminarMuertos(heroes);
            ataqueHeroesABestias();
            eliminarMuertos(bestias);
        }
    }

    private void ataqueHeroesABestias() {
        System.out.println("\n ------ HEROES ATACAN A BESTIAS -------- ");
        for (int i = 0; i < bestias.length; i++) {
            if (heroes[i] != null && bestias[i] != null) {
                System.out.print(heroes[i] + " <-VS-> " + bestias[i]);
                heroes[i].atacar(bestias[i]);
            }
        }
    }

    private void ataqueBestiasAHeroes() {
        System.out.println("\n ------ BESTIAS ATACAN A HEROES -------- ");
        for (int i = 0; i < bestias.length; i++) {
            if (heroes[i] != null && bestias[i] != null) {
                System.out.print(bestias[i] + " <-VS-> " + heroes[i]);
                bestias[i].atacar(heroes[i]);
            }
        }
    }

    private void generarEquipos() {
        for (int i = 0; i < bestias.length; i++) {
            bestias[i] = generarLuchador(true);
        }

        for (int i = 0; i < heroes.length; i++) {
            heroes[i] = generarLuchador(false);
        }
    }

    private Luchador generarLuchador(boolean esBestia) {
        int tipo;
        Luchador luchador = null;

        if (esBestia) {
            tipo = MotorJuego.generarNumAleatorio(1, 2);
            switch (tipo) {
                case 1:
                    luchador = new Orco();
                    break;
                case 2:
                    luchador = new Trasgo();
                    break;
            }
        } else {
            tipo = MotorJuego.generarNumAleatorio(1, 3);
            switch (tipo) {
                case 1:
                    luchador = new Elfo();
                    break;
                case 2:
                    luchador = new Hobbit();
                    break;
                case 3:
                    luchador = new Humano();
                    break;
            }
        }

        return luchador;
    }

    public static int generarNumAleatorio(int inicio, int fin) {
        int numero;
        numero = (int) (inicio + Math.random() * (fin - inicio + 1));
        return numero;
    }
}
