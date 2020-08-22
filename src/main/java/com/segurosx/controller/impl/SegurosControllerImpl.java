/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.controller.impl;

import com.segurosx.config.Paths;
import com.segurosx.controller.SegurosController;
import com.segurosx.models.AgenteMediator;
import com.segurosx.models.BeneficiarioMediator;
import com.segurosx.models.ContratanteMediator;
import com.segurosx.models.Persona;
import com.segurosx.models.Poliza;
import com.segurosx.models.Seguro;
import com.segurosx.models.Beneficiario;
import com.segurosx.models.patterns.IObserver;
import com.segurosx.repository.SeguroRepository;
import io.javalin.http.Context;
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;

/**
 *
 * @author Giannela HC
 */
public class SegurosControllerImpl implements SegurosController{

    private static final String ID = "id";

    private SeguroRepository orderRepository;

    public SegurosControllerImpl(SeguroRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    @Override
    public void create(Context context) {
//        try {
            Seguro seguro = context.bodyAsClass(Seguro.class);
            
            seguro.setPoliza(new Poliza(122122, "Juan Pablo", "Juan Perez", 12.4));
            
//            ContratanteMediator me = new ContratanteMediator();
//            AgenteMediator agen = new AgenteMediator();
//            BeneficiarioMediator ben = new BeneficiarioMediator();
//            System.out.println("aun no contratante medi");
//            seguro.setMediator(me);
//            seguro.getAgente().setMediator(agen);
//            seguro.getContratante().setMediator(me);
//            seguro.getBeneficiarios().forEach(b -> {
//                b.setMediator(ben);
//            });
            System.out.println("despes contratante medi");
            seguro.addAllObservers();
            //seguro.updateSumaAsegurada(34.5);
            
            orderRepository.create(seguro);
            context.json(seguro);
            
            context.status(HttpStatus.CREATED_201)
                    .header(HttpHeader.LOCATION.name(), Paths.formatPostLocation(seguro.getNumero()));
//        } catch (AWTException ex) {
//            Logger.getLogger(SegurosControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }

       
    
    }
}