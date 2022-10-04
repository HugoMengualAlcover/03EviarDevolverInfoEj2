package com.example.a03eviardevolverinfoej2.modelos;

import java.io.Serializable;

public class Moto implements Serializable {
    String marca;
    String modelo;
    String cilindrada;

    public Moto() {
    }

    public Moto(String marca, String modelo, String cilindrada) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setColor(String cilindrada) {
        this.cilindrada = cilindrada;
    }
}
