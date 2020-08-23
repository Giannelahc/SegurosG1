package com.segurosx.models;

import com.segurosx.models.patterns.IMediator;
import com.segurosx.models.patterns.IObserver;


public class EnvioMediator implements IMediator<Persona> {

    private EnvioSmtp sendMail;

    public EnvioMediator() {
        sendMail = new EnvioSmtp("smtp", this);
    }
    
    @Override
    public void enviaCorreoSMTP(Persona persona,String as) {
        //sendMail = new EnvioSmtp("smtp", this);
        // enviando correo...
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append(" Mensaje enviado a: ");
        cuerpo.append(as);
        cuerpo.append("\n  Involucrado: ");
        cuerpo.append("\n       RUC: ");cuerpo.append(persona.getRuc());
        cuerpo.append("\n       Nombre: ");cuerpo.append(persona.getNombre());
        cuerpo.append("\n       Direccion: ");cuerpo.append(persona.getDireccion());
        cuerpo.append("\n       Correo: ");cuerpo.append(persona.getCorreo());
        sendMail.preparaMensaje(as,cuerpo.toString(),persona.getCorreo());
    }

    @Override
    public void notify(Seguro seguro,String as) {
        for( IObserver a : seguro.contratantes) {
            a.notifica(as);
        }
    }
    
}
