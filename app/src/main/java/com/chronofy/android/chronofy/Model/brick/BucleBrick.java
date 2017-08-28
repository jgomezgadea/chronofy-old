package com.chronofy.android.chronofy.Model.brick;

/**
 * Created by Jose on 26/08/2017.
 */

public class BucleBrick implements GenericBrick {

    private String nombre;
    private int posicion;
    private int numRep;

    public BucleBrick(String nom, int pos, int nr) {
        nombre = nom;
        posicion = pos;
        numRep = nr;
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

    public int getNumRep() {
        return numRep;
    }

    public void setNumRep(int nr) {
        numRep = nr;
    }
}
