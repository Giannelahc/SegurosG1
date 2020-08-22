/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.models;

import com.segurosx.models.patterns.IMediator;
import com.segurosx.models.patterns.IObserver;

/**
 *
 * @author Giannela HC
 */
public class BeneficiarioMediator implements IMediator<Beneficiario>{
    
    private EnvioSmtp sendMail;

    public BeneficiarioMediator() {
        sendMail = new EnvioSmtp("smtp", this);
    }
    
    @Override
    public void enviaCorreoSMTP(Beneficiario beneficiario,String as) {
        
        // enviando correo...
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append(" Mensaje enviado a: ");
        cuerpo.append(as);
        cuerpo.append("\n  Beneficiario: ");
        cuerpo.append("\n       DNI: ");cuerpo.append(beneficiario.getDni());
        cuerpo.append("\n       Nombre: ");cuerpo.append(beneficiario.getNombre());
        cuerpo.append("\n       Direccion: ");cuerpo.append(beneficiario.getDireccion());
        cuerpo.append("\n       Correo: ");cuerpo.append(beneficiario.getCorreo());
        sendMail.preparaMensaje(as,cuerpo.toString(),beneficiario.getCorreo());
        
    }

    @Override
    public void notify(Seguro seguro,String as) {
        for( IObserver a : seguro.contratantes) {
            System.out.println("entra beneficiario mediator");
            a.notifica(as);
        }
    }
}
