package com.segurosx.models;

import com.segurosx.models.patterns.*;
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeguroVehicular extends Seguro implements INivelRiesgo, IVehicularObserver {

    private VehicularProblemCenter vehicularProblemCenter;
    private ICobertura cobertura;

    public SeguroVehicular(String marca, String modelo, IMediator mediator, VehicularProblemCenter vehicularProblemCenter) {
        super(mediator);
        this.marca = marca;
        this.modelo = modelo;
        this.vehicularProblemCenter = vehicularProblemCenter;

    }

    public SeguroVehicular() {
    }

    @Override
    public void calcularRiesgo() {

        if (this.marca.equals("Toyota") && this.modelo.equals("Yaris")) {
            this.nivelRiesgo = "ALTO";
        } else {
            this.nivelRiesgo = "BAJO";
        }

    }

    @Override
    public String getDetalleSeguro() {

        return "Seg. Vehicular Numero: " + this.numero + " con riesgo: " + this.nivelRiesgo;
    }

    public void calcularCobeturaVehicular() {

        this.cobertura = new CoberturaTodoRiesgoDecorator(
                new CoberturaBasicaVehicular());
        cobertura.calculaCobertura();
    }

    @Override
    public void update() {
        //this.poliza.setSumaAsegurada(this.getPoliza().getSumaAsegurada() + vehicularProblemCenter.getAmount());
        try {
            this.updateSumaAsegurada(this.getPoliza().getSumaAsegurada() + vehicularProblemCenter.getAmount());
        } catch (AWTException ex) {
            Logger.getLogger(SeguroVehicular.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.vehicularProblemCenter.describeProblem();
        System.out.println("Nueva suma asegurada total: " + this.poliza.getSumaAsegurada());
    }

}