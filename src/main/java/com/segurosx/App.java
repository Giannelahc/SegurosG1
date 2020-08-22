package com.segurosx;

import com.segurosx.models.*;
//import com.segurosx.models.patterns.PolizaAdapter2;
import com.segurosx.models.patterns.VehicularProblemCenter;

import java.awt.*;
import java.util.ArrayList;

/**
 * HRCS
 *
 */
public class App 
{
    public static void main( String[] args ) throws AWTException {

//        Cliente cliente = new Cliente("Juan Perez");
//        
//        SeguroVehicular seguro = new SeguroVehicular("Toyota","Yaris");
//        seguro.calcularRiesgo();
//        seguro.calcularCobeturaVehicular();
//        cliente.setCompraSeguro(seguro);
//        System.out.println( seguro.getDetalleSeguro() );
//
//
//        SeguroTarjeta seguro2 = new SeguroTarjeta("BCP");
//        seguro2.calcularRiesgo();
//        seguro2.setPoliza(new Poliza(122122, "Juan Pablo", "Juan Perez", 12.4));
//        cliente.setCompraSeguro(seguro2);
//        System.out.println( seguro2.getDetalleSeguro() );
//
//        CorreoMediator correoMediator = new CorreoMediator();
//        ClienteAsegurado asegurado = new ClienteAsegurado("Pedro Pablo", correoMediator);
//        asegurado.enviaCorreo();
//
//
//        seguro2.addObserver(cliente);
//        seguro2.addObserver(asegurado);
//        seguro2.setSumaAsegurada(34.5);


        ContratanteMediator me = new ContratanteMediator();
        AgenteMediator agen = new AgenteMediator();
        BeneficiarioMediator ben = new BeneficiarioMediator();
        SeguroTarjeta seguro2 = new SeguroTarjeta("BCP",me);
        seguro2.calcularRiesgo();
        seguro2.setPoliza(new Poliza(122122, "Juan Pablo", "Juan Perez", 12.4));
        
        
        Contratante p = new Contratante("Giannela","Av.","giannela.huamani@unmsm.edu.pe","7412589",me);
        Agente p1 = new Agente("mariana","","giannela.huamani@unmsm.edu.pe",agen);
        Beneficiario p2 = new Beneficiario("Alvaro Rivera Deza","Calle 1 Foo Don Carlos Mz.H Lt. T7","alvaro.rivera@unmsm.edu.pe","72533828",ben);
        Beneficiario p3 = new Beneficiario("Maria Rodriguez","Calle Caceres 125","marirode142@gmail.com","12345678",ben);
        List<Beneficiario> b1 =new ArrayList<>();
        b1.add(p2);b1.add(p3);
//        seguro2.addObserver(p);
//        seguro2.addObserver(p1);
//        seguro2.addObserver(p2);
        seguro2.setAgente(p1);
        seguro2.setContratante(p);
        seguro2.setBeneficiarios(b1);
        seguro2.removeObserver(p1);
        seguro2.setSumaAsegurada(34.5);



        // Demo Problema 4
        VehicularProblemCenter vehicularProblemCenter = new VehicularProblemCenter();
        ContratanteMediator me = new ContratanteMediator();

        SeguroVehicular seguro = new SeguroVehicular("Toyota","Yaris", me, vehicularProblemCenter);
        seguro.setPoliza(new Poliza(122122, "Juan Pablo", "Juan Perez", 12.4));
        seguro.calcularRiesgo();
        seguro.calcularCobeturaVehicular();

        vehicularProblemCenter.add(seguro);

        vehicularProblemCenter.setProblem("Accidente", 220.0);
        vehicularProblemCenter.setProblem("Incidente", 2999.0);


   }
}
