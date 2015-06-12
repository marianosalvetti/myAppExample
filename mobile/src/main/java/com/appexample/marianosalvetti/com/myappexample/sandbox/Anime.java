package com.appexample.marianosalvetti.com.myappexample.sandbox;

/**
 * Created by Mariano Salvetti on 12/06/2015
 *
 * El atributo imagen guarda la identificación de una imagen que almacenaremos
 * en los recursos drawables para realizar una referencia directa.
 */

public class Anime {
    private int imagen;
    private String nombre;
    private int visitas;

    public Anime(int imagen, String nombre, int visitas) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.visitas = visitas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVisitas() {
        return visitas;
    }

    public int getImagen() {
        return imagen;
    }
}
