package com.segurosx.models.patterns;

import com.segurosx.models.ICobertura;

public class CoberturaTodoRiesgoDecorator extends CoberturaDecorator {

    public CoberturaTodoRiesgoDecorator(ICobertura cobertura) {
        super(cobertura);
    }
    
    @Override
    public void calculaCobertura() {
        super.calculaCobertura();
        agregarDanosTodoRiesgo();
    }

    private void agregarDanosTodoRiesgo() {
        System.out.println("Daños por todo riesgo al vehiculo");
    }    
}