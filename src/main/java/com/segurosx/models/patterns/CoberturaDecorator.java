package com.segurosx.models.patterns;

import com.segurosx.models.ICobertura;

public class CoberturaDecorator implements ICobertura {

    public final ICobertura cobertura;

    public CoberturaDecorator(ICobertura cobertura)    {

        this.cobertura = cobertura;
    }

    @Override
    public void calculaCobertura() {
        
        this.cobertura.calculaCobertura();
    }
    
}