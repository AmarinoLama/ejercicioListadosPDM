package com.example.listados;

import java.io.Serializable;

public class Animal implements Serializable {

    private String nombre;
    private int imagen;
    private boolean seleccionado;

    public Animal(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
        seleccionado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setVerificado(boolean verificado) {
        this.seleccionado = verificado;
    }
}