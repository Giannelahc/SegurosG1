/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.segurosx.models.patterns.IMediator;
import com.segurosx.models.patterns.IObserver;

/**
 *
 * @author Giannela HC
 */

public abstract class Persona implements IObserver{
    
    protected String nombre;
    protected String direccion;
    protected String correo;
    protected IMediator mediator;
    protected boolean suscrip = true;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public IMediator getMediator() {
        return mediator;
    }

    public void setMediator(IMediator mediator) {
        this.mediator = mediator;
    }

    public boolean isSuscrip() {
        return suscrip;
    }

    public void setSuscrip(boolean suscrip) {
        this.suscrip = suscrip;
    }
    
}
