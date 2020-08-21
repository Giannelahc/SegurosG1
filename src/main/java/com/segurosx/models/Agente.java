/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.models;

import com.segurosx.models.patterns.IMediator;
import java.util.Random;

/**
 *
 * @author Giannela HC
 */
public class Agente extends Persona{

    protected String codigo;
    
    public Agente(String nombre, String direccion,String correo,IMediator mediator) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.codigo = "A" +String.valueOf(new Random().nextInt());
        this.mediator = mediator;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public void notifica() {
        this.mediator.enviaCorreoSMTP(this);
    }
    
}
