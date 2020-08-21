package com.segurosx.models.patterns;

import com.segurosx.models.IExportable;
import com.segurosx.models.Poliza;

public class PolizaAdapter2 extends Poliza implements IExportable {

    public PolizaAdapter2(Integer numero, String nombresAsegurado, String nombresTomador, Double suma) {
        super(numero, nombresAsegurado, nombresTomador, suma);
    }

    @Override
    public String aXML() {
        
        StringBuffer xml = new StringBuffer();
        xml.append("<envio>");
        xml.append("<title>Formato XML</title>");
        xml.append("<poliza>");
        xml.append("<numero>" + getNumero() + "</numero>");
        xml.append("<nombresAsegurado>" + getNombresAsegurado() + "</nombresAsegurado>");
        xml.append("<nombresTomador>" + getNombresTomador() + "</nombresTomador>");
        xml.append("</poliza>");
        xml.append("</envio>");

        return xml.toString();
    }

    @Override
    public String aTexto() {
        return armarSalidaTexto();
    }
    
}