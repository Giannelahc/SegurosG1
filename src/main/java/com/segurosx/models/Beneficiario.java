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

    public String getDni() {
        return dni;
    }

    @Override
    public void notifica() {
        this.mediator.enviaCorreoSMTP(this);
    }
    
    
    
}
