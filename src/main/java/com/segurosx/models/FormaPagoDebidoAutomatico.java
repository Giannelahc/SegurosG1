package com.segurosx.models;

public class FormaPagoDebidoAutomatico implements IFormaPago {

    @Override
    public void realizaDescuentoAutomaticoBanco() {
        System.out.println("Genera cargo en la cuenta de debito automatico");
    }

    @Override
    public void generaCuponPago() {
        
        throw new UnsupportedOperationException();
    }

    @Override
    public void programaFechaVencimientoCuponPago() {

        throw new UnsupportedOperationException();
    }

    
}