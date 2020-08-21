package com.segurosx.models;

public class CuponPago implements IFormaPagoCupon   {

    @Override
    public void generaCuponPago() {

        System.out.println("Genera Cupon de pago 1");
        System.out.println("Genera Cupon de pago 2");
    }

    @Override
    public void programaFechaVencimientoCuponPago() {
        
        System.out.println("Programa fecha de vencimiento cupon 1 en julio 2020");
        System.out.println("Programa fecha de vencimiento cupon 2 en agosto 2020");
    }


    
}