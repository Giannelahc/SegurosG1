package com.segurosx.models;

import com.segurosx.models.patterns.IMediator;
import java.awt.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import com.segurosx.models.patterns.IObserver;
import com.segurosx.models.patterns.ISeguroObservable;

public abstract class Seguro implements ISeguroObservable {

    protected Integer numero;
    protected Certificado certificado;
    protected Poliza poliza;
    protected Contratante contratante;
    protected Agente agente;
    protected List<Beneficiario> beneficiarios;
    protected String nivelRiesgo = "NINGUNO";
    protected String bancoTarjeta;
    protected String marca;
    protected String modelo;
    protected List<IObserver> contratantes;
    private IMediator mediator;

    public Seguro(IMediator mediator) {
        this.mediator = mediator;
        this.numero = new Integer(new Random().nextInt());
        this.certificado = new Certificado();
        this.contratantes = new ArrayList<IObserver>();
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(final Certificado certificado) {
        this.certificado = certificado;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(final Poliza poliza) {
        this.poliza = poliza;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(final Integer numero) {
        this.numero = numero;
    }

    public String getNivelRiesgo() {
        return this.nivelRiesgo;
    }

    public void setContratante(Contratante contratante) {
        if(contratante!=null && contratante.isSuscrip()){
            this.contratante = contratante;
            addObserver(this.contratante);
        }
    }

    public void setAgente(Agente agente) {
        if(this.agente!=null && this.agente.isSuscrip()){
            this.agente = agente;
            addObserver(this.agente);
        }
    }

    public void setBeneficiarios(List<Beneficiario> beneficiarios) {
        if(!beneficiarios.isEmpty()){
            this.beneficiarios = beneficiarios;
            this.beneficiarios.stream().filter(b -> (b.isSuscrip())).forEachOrdered(b -> {
                addObserver(b);
            });
        }
    }

    

    public abstract String getDetalleSeguro();

    public void setSumaAsegurada(final Double suma) throws AWTException {

        this.poliza.setSumaAsegurada(suma);
        // notify contratante
        System.out.println("***********************************************************");
        System.out.println("Se modifico la Suma Asegurada, notificando... ");
        System.out.println("***********************************************************");
        this.mediator.notify(this);
    }

    @Override
    public void addObserver(IObserver observer) {
        this.contratantes.add( observer );
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.contratantes.remove( observer );
    }   

    public void addAllObservers(){
        this.setAgente(this.agente);
        this.setBeneficiarios(this.beneficiarios);
        this.setContratante(this.contratante);
    }
}
