package com.example.danielfigueroa_parcial1android;

import java.util.UUID;

public class Usuario {

    private String nombre;
    private int posX;
    private int posY;
    private int vel;
    private int rojo;
    private int verde;
    private int azul;

    public Usuario() {
    }

    public int getRojo() {
        return rojo;
    }

    public void setRojo(int rojo) {
        this.rojo = rojo;
    }

    public int getVerde() {
        return verde;
    }

    public void setVerde(int verde) {
        this.verde = verde;
    }

    public int getAzul() {
        return azul;
    }

    public void setAzul(int azul) {
        this.azul = azul;
    }

    public Usuario (String nombre, int posX, int posY, int rojo, int verde, int azul){
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.rojo = rojo;
        this.verde = verde;
        this.azul = azul;
        //usar rojo verde azul y que sean numero enteros con RGB tambien se puede hacer uso de un string
        this.vel = 3;

    }

    public void moverIzquierda() {
        //if (posX > 0 && posX < 600) {
            posX -= vel;
        //}
    }

    public void moverDerecha() {
        //if (posX > 0 && posX < 600) {
            posX += vel;
        //}
    }

    public void moverAbajo() {
        //if (posY > 0 && posY < 800) {
            posY -= vel;
        //}
    }

    public void moverArriba() {
        //if (posY > 0 && posY < 800) {
            posY += vel;
        //}
    }

    public void cambioColor(){
        rojo -=255;
                verde=0;
                azul+=255;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }


}
