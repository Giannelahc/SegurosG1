package com.segurosx.models.patterns;

import com.segurosx.models.ICobertura;

public class CoberturaPorChoqueDecorator extends CoberturaDecorator {
    
    public CoberturaPorChoqueDecorator(ICobertura cobertura) {
        super(cobertura);
    }

    @Override
    public void calculaCobertura() {
        super.calculaCobertura();
        agregarDanosPorChoque();
    }

    private void agregarDanosPorChoque() {
        System.out.println("Daños por choque al vehiculo");
    }
        
}