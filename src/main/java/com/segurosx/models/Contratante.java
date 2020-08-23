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

    public Contratante(String nombre, String direccion,String correo,String ruc, IMediator mediator) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.ruc = ruc;
        this.mediator = mediator;
    }

    public Contratante() {
        this.mediator= new EnvioMediator();
    }

    public void setMediator(IMediator mediator) {
        this.mediator = mediator;
    }
    public IMediator getMediator() {
        return mediator;
    }
    @Override
    public void notifica(String as) {
        this.mediator.enviaCorreoSMTP(this,as);
    }
    
    
}
