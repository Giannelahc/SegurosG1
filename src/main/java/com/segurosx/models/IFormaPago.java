package com.segurosx.models;

public interface IFormaPago {
    
    public void realizaDescuentoAutomaticoBanco();
    public void generaCuponPago();
    public void programaFechaVencimientoCuponPago();
}