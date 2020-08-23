/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.controller.impl;

import com.segurosx.config.Paths;
import com.segurosx.controller.SegurosController;
import com.segurosx.models.Persona;
import com.segurosx.models.Poliza;
import com.segurosx.models.Seguro;
import com.segurosx.models.Contratante;
import com.segurosx.models.EnvioMediator;
import com.segurosx.models.SeguroVehicular;
import com.segurosx.models.patterns.IObserver;
import com.segurosx.models.patterns.VehicularProblemCenter;
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

    private SeguroRepository seguroRepository;

    public SegurosControllerImpl(SeguroRepository seguroRepository) {
        this.seguroRepository = seguroRepository;
    }
    
    @Override
    public void create(Context context) {
//        try {
            Seguro seguro = context.bodyAsClass(Seguro.class);
            
            seguro.setPoliza(new Poliza(122122, "Juan Pablo", "Juan Perez", 12.4));
            
//            ContratanteMediator me = new ContratanteMediator();
//            AgenteMediator agen = new AgenteMediator();
//            BeneficiarioMediator ben = new BeneficiarioMediator();
//            seguro.setMediator(me);
//            seguro.getAgente().setMediator(agen);
//            seguro.getContratante().setMediator(me);
//            seguro.getBeneficiarios().forEach(b -> {
//                b.setMediator(ben);
//            });

            seguro.addAllObservers();
            //seguro.updateSumaAsegurada(34.5);
            
            // Demo Problema 4
        VehicularProblemCenter vehicularProblemCenter = new VehicularProblemCenter();
        EnvioMediator me = new EnvioMediator();
        Contratante c1 = new Contratante("Giannela","Av.","giannela.huamani@unmsm.edu.pe","7412589",me);
        SeguroVehicular seguro1 = new SeguroVehicular("Toyota","Yaris", me, vehicularProblemCenter);
        seguro1.setPoliza(new Poliza(122122, "Juan Pablo", "Juan Perez", 12.4));
        seguro1.calcularRiesgo();
        seguro1.calcularCobeturaVehicular();
        seguro1.addObserver(c1);

        vehicularProblemCenter.add(seguro1);

        vehicularProblemCenter.setProblem("Accidente", 220.0);
        vehicularProblemCenter.setProblem("Incidente", 2999.0);
            
            
            seguroRepository.create(seguro);
            context.json(seguro);
            
            context.status(HttpStatus.CREATED_201)
                    .header(HttpHeader.LOCATION.name(), Paths.formatPostLocation(seguro.getNumero()));
//        } catch (AWTException ex) {
//            Logger.getLogger(SegurosControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }

       
    
    }
}