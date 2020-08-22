package com.segurosx.models;

import com.segurosx.models.patterns.IMediator;
import com.segurosx.models.patterns.IObserver;


public class ContratanteMediator implements IMediator<Contratante> {

    private EnvioSmtp sendMail;

    public ContratanteMediator() {
        sendMail = new EnvioSmtp("smtp", this);
    }
    
    @Override
    public void enviaCorreoSMTP(Contratante contratante,String as) {
        //sendMail = new EnvioSmtp("smtp", this);
        // enviando correo...
        StringBuilder cuerpo = new StringBuilder();
        cuerpo.append(" Mensaje enviado a: ");
        cuerpo.append(as);
        cuerpo.append("\n  Contratante: ");
        cuerpo.append("\n       RUC: ");cuerpo.append(contratante.getRuc());
        cuerpo.append("\n       Nombre: ");cuerpo.append(contratante.getNombre());
        cuerpo.append("\n       Direccion: ");cuerpo.append(contratante.getDireccion());
        cuerpo.append("\n       Correo: ");cuerpo.append(contratante.getCorreo());
        sendMail.preparaMensaje(as,cuerpo.toString(),contratante.getCorreo());
        
    }

    @Override
    public void notify(Seguro seguro,String as) {
        for( IObserver a : seguro.contratantes) {
            System.out.println("entra contratante mediator");
            a.notifica(as);
        }
    }
}
