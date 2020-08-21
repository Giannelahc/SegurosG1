package com.segurosx.models;

import java.util.Random;

public class Certificado {
    
    private Integer numero;

    public Certificado(){
        this.numero = new Integer(new Random().nextInt());
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}