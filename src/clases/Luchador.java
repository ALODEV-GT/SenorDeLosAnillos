package clases;

import manejador.MotorJuego;

public abstract class Luchador {
    private String nombre;
    private int vida;
    private int armadura;
    private boolean vivo = true;

    // Constructores
    public Luchador(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
        establecerArmadura();
    }

    // Metodos abstractos
    public abstract void atacar(Luchador enemigo);

    // Getters y Setters
    public String getNombre() {
        return this.nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public int getArmadura() {
        return this.armadura;
    }

    public boolean estaVivo() {
        return this.vivo;
    }

    public void setVida(int danio) {
        this.vida -= danio;
        if (this.vida <= 0) {
            this.vivo = false;
        }
    }

    // Otros metodos
    private void establecerArmadura() {
        this.armadura = MotorJuego.generarNumAleatorio(50, 70);
    }
}