package com.example.a03eviardevolverinfoej2.modelos;

import java.io.Serializable;

public class Bici implements Serializable {
    private String Marca;
    private String Pulgadas;

    public Bici() {
    }

    public Bici(String marca, String pulgadas) {
        Marca = marca;
        Pulgadas = pulgadas;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getPulgadas() {
        return Pulgadas;
    }

    public void setPulgadas(String pulgadas) {
        Pulgadas = pulgadas;
    }
}
