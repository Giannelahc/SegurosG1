package com.segurosx.models;

public class FormaPagoCuponPago implements IFormaPago   {

    @Override
    public void realizaDescuentoAutomaticoBanco() {

        throw new UnsupportedOperationException();
    }

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