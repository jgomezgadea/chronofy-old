package com.chronofy.android.chronofy.Model.brick;

/**
 * Created by Jose on 26/08/2017.
 */

public class TimeBrick implements GenericBrick {

    private String nombre;
    private int posicion;
    private int tiempo;

    public TimeBrick(String nom, int pos, int t) {
        nombre = nom;
        posicion = pos;
        tiempo = t;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nom) {
        nombre = nom;
    }

    @Override
    public int getPosicion() {
        return posicion;
    }

    @Override
    public void setPosicion(int pos) {
        posicion = pos;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int t) {
        tiempo = t;
    }
}