package com.segurosx.models;

import com.segurosx.models.patterns.CoberturaBasicaVehicular;
import com.segurosx.models.patterns.CoberturaPorChoqueDecorator;
import com.segurosx.models.patterns.CoberturaTodoRiesgoDecorator;
import com.segurosx.models.patterns.IMediator;

public class SeguroVehicular extends Seguro implements INivelRiesgo {

    private ICobertura cobertura;
    
    public SeguroVehicular(String marca, String modelo, IMediator mediator)    {

        super(mediator);
        this.marca = marca;
        this.modelo = modelo;

    }

    public SeguroVehicular() {
    }

    @Override
    public void calcularRiesgo() {

        if (this.marca.equals("Toyota") && this.modelo.equals("Yaris")) {
            this.nivelRiesgo = "ALTO";
        }
        else {
            this.nivelRiesgo = "BAJO";
        } 

    }

    @Override
    public String getDetalleSeguro()    {

        return "Seg. Vehicular Numero: " + this.numero + " con riesgo: " + this.nivelRiesgo;
    }

    public void calcularCobeturaVehicular() {

        this.cobertura = new CoberturaTodoRiesgoDecorator(
                            new CoberturaBasicaVehicular());
        cobertura.calculaCobertura();        
    }
}