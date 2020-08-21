package com.segurosx.models;

import com.segurosx.models.patterns.IMediator;
import com.segurosx.models.patterns.IObserver;


public class ContratanteMediator implements IMediator<Contratante> {

    private EnvioSmtp sendMail;
    @Override
    public void enviaCorreoSMTP(Contratante contratante) {
        sendMail = new EnvioSmtp("smtp", this);
        // enviando correo...
        String asunto = "Modificacion de suma asegurada";
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append(" Mensaje enviado a: ");
        cuerpo.append("\n  Contratante: ");
        cuerpo.append("\n       RUC: ");cuerpo.append(contratante.getRuc());
        cuerpo.append("\n       Nombre: ");cuerpo.append(contratante.getNombre());
        cuerpo.append("\n       Direccion: ");cuerpo.append(contratante.getDireccion());
        cuerpo.append("\n       Correo: ");cuerpo.append(contratante.getCorreo());
        sendMail.preparaMensaje(asunto,cuerpo.toString(),contratante.getCorreo());
        
    }

    @Override
    public void notify(Seguro seguro) {
        for( IObserver a : seguro.contratantes) {

            a.notifica();
        }
    }
}
