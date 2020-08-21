package com.segurosx.models.patterns;

import com.segurosx.models.ICobertura;

public class CoberturaBasicaVehicular implements ICobertura {

    @Override
    public void calculaCobertura() {
        System.out.println("El seguro vehicular cubre: ");
        agregarDanosVehiculo();
    }

    private void agregarDanosVehiculo() {
        System.out.println("Daños al vehiculo");
    }    
    
}