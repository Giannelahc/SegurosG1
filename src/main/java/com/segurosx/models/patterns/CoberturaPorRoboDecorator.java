package com.segurosx.models.patterns;

import com.segurosx.models.ICobertura;

public class CoberturaPorRoboDecorator extends CoberturaDecorator {

    public CoberturaPorRoboDecorator(ICobertura cobertura) {
        super(cobertura);
    }

    @Override
    public void calculaCobertura() {
        super.calculaCobertura();
        agregarDanosPorRobo();
    }

    private void agregarDanosPorRobo() {
        System.out.println("Daños por robo al vehiculo");
    }
    
}