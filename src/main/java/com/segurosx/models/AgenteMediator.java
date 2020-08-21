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
public class AgenteMediator implements IMediator<Agente>{
    
    private EnvioSmtp sendMail;
    

    @Override
    public void enviaCorreoSMTP(Agente agente) {
        sendMail = new EnvioSmtp("smtp", this);
        // enviando correo...
        String asunto = "Modificacion de suma asegurada";
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append(" Mensaje enviado a: ");
        cuerpo.append("\n  Agente: ");
        cuerpo.append("\n       Código: ");cuerpo.append(agente.getCodigo());
        cuerpo.append("\n       Nombre: ");cuerpo.append(agente.getNombre());
        cuerpo.append("\n       Direccion: ");cuerpo.append(agente.getDireccion());
        cuerpo.append("\n       Correo: ");cuerpo.append(agente.getCorreo());
        sendMail.preparaMensaje(asunto,cuerpo.toString(),agente.getCorreo());
        
    }

    @Override
    public void notify(Seguro seguro) {
        for( IObserver a : seguro.contratantes) {

            a.notifica();
        }
    }
}
