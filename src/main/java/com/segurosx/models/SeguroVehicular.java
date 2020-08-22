package com.segurosx.models;

import com.segurosx.models.patterns.*;

public class SeguroVehicular extends Seguro implements INivelRiesgo, IVehicularObserver {

    private VehicularProblemCenter vehicularProblemCenter;
    private ICobertura cobertura;

    public SeguroVehicular(String marca, String modelo, IMediator mediator, VehicularProblemCenter vehicularProblemCenter) {
        super(mediator);
        this.marca = marca;
        this.modelo = modelo;
        this.vehicularProblemCenter = vehicularProblemCenter;

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
        this.poliza.setSumaAsegurada(this.getPoliza().getSumaAsegurada() + vehicularProblemCenter.getAmount());
        this.vehicularProblemCenter.describeProblem();
        System.out.println("Nueva suma asegurada total: " + this.poliza.getSumaAsegurada());
    }

}