package com.chronofy.android.chronofy.Model;

/**
 * Created by Jose on 28/08/2017.
 */

public class Brick {
    // TODO Hacer documentación
    // TODO Hará falta añadir una variable que indique si es un brick bucle o tiempo, y las variables de ambos
    // De momento solo tiene un String y un int de prueba

    private String nombre;
    private int tipo;

    public Brick(String nombre, int tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipo() {
        return tipo;
    }
}
