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
    
    @Override
    public void enviaCorreoSMTP(Beneficiario beneficiario) {
        sendMail = new EnvioSmtp("smtp", this);
        // enviando correo...
        String asunto = "Modificacion de suma asegurada";
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append(" Mensaje enviado a: ");
        cuerpo.append("\n  Beneficiario: ");
        cuerpo.append("\n       DNI: ");cuerpo.append(beneficiario.getDni());
        cuerpo.append("\n       Nombre: ");cuerpo.append(beneficiario.getNombre());
        cuerpo.append("\n       Direccion: ");cuerpo.append(beneficiario.getDireccion());
        cuerpo.append("\n       Correo: ");cuerpo.append(beneficiario.getCorreo());
        sendMail.preparaMensaje(asunto,cuerpo.toString(),beneficiario.getCorreo());
        
    }

    @Override
    public void notify(Seguro seguro) {
        for( IObserver a : seguro.contratantes) {

            a.notifica();
        }
    }
}
