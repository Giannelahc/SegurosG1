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
public class Contratante extends Persona{

    protected String ruc;
    
    public Contratante(String nombre, String direccion,String correo,String ruc, IMediator mediator) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.ruc = ruc;
        this.mediator = mediator;
    }

    public String getRuc() {
        return ruc;
    }

    @Override
    public void notifica() {
        this.mediator.enviaCorreoSMTP(this);
    }
    
    
}
