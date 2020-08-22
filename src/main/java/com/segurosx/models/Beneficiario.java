/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.models;

import com.segurosx.models.patterns.IMediator;

/**
 *
 * @author Giannela HC
 */
public class Beneficiario extends Persona{
    
    protected String dni;

    public Beneficiario(String nombre, String direccion,String correo,String dni, IMediator mediator) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.dni = dni;
        this.mediator = mediator;
    }

    public Beneficiario() {
        this.mediator = new BeneficiarioMediator();
    }

    public String getDni() {
        return dni;
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
