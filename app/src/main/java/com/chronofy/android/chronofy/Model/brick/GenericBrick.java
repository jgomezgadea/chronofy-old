package com.chronofy.android.chronofy.Model.brick;

/**
 * Created by Jose on 26/08/2017.
 */

public abstract class GenericBrick {
    protected static String nombre;
    protected int posicion;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nom) {
        nombre = nom;
    }

    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int pos) {
        posicion = pos;
    }
}