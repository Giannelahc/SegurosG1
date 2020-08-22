package com.segurosx.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.segurosx.models.patterns.IMediator;
import java.awt.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import com.segurosx.models.patterns.IObserver;
import com.segurosx.models.patterns.ISeguroObservable;
import java.util.Optional;


@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "type")
@JsonSubTypes({ 
  @JsonSubTypes.Type(value = SeguroTarjeta.class, name = "tarjeta"), 
  @JsonSubTypes.Type(value = SeguroVehicular.class, name = "vehicular") 
})
public abstract class Seguro implements ISeguroObservable {

    protected String numero;
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
        //this.numero = new Integer(new Random().nextInt());
        this.certificado = new Certificado();
        this.contratantes = new ArrayList<>();
    }

    public Seguro() {
        this.certificado = new Certificado();
        this.contratantes = new ArrayList<>();this.mediator = new ContratanteMediator();
    }
    
    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(final Certificado certificado) {
        this.certificado = certificado;
    }

    public String getBancoTarjeta() {
        return bancoTarjeta;
    }

    public List<IObserver> getContratantes() {
        return contratantes;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(final Poliza poliza) {
        this.poliza = poliza;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public void setMediator(IMediator mediator) {
        this.mediator = mediator;
    }

    public IMediator getMediator() {
        return mediator;
    }

    public String getNivelRiesgo() {
        return this.nivelRiesgo;
    }

//    public List<IObserver> getContratantes() {
//        return contratantes;
//    }
//
//    public void setContratantes(List<IObserver> contratantes) {
//        this.contratantes = contratantes;
//    }

    public void setContratante(Contratante contratante) {
        if(contratante!=null)//{
            this.contratante = contratante;
//            if(contratante.isSuscrip())
//                addObserver(this.contratante);
//        }
    }

    public void setAgente(Agente agente) {
        if(agente!=null )//{
            this.agente = agente;
//            if(agente.isSuscrip())
//                addObserver(this.agente);
//        }
    }

    public Contratante getContratante() {
        return contratante;
    }

    public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setBeneficiarios(List<Beneficiario> beneficiarios) {
        if(!beneficiarios.isEmpty())//{
            this.beneficiarios = beneficiarios;
//            this.beneficiarios.stream().filter(b -> (b.isSuscrip())).forEachOrdered(b -> {
//                addObserver(b);
//            });
//        }
    }
    public abstract String getDetalleSeguro();

    public void updateSumaAsegurada(final Double suma) throws AWTException {

        this.poliza.setSumaAsegurada(suma);
        // notify contratante
        System.out.println("***********************************************************");
        System.out.println("Se modifico la Suma Asegurada, notificando... ");
        System.out.println("***********************************************************");
        this.mediator.notify(this,"Se modifico la Suma Asegurada a: "+suma);
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
        if(!this.beneficiarios.isEmpty()){
            this.beneficiarios.stream().filter(b -> (b.isSuscrip())).forEachOrdered(b -> {
                addObserver(b);
            });
        }
        if(this.agente !=null && this.agente.isSuscrip())
            addObserver(this.agente);
        if(this.contratante !=null && this.contratante.isSuscrip())
            addObserver(this.contratante);
    }
}
