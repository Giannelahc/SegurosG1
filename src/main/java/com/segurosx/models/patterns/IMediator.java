package com.segurosx.models.patterns;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.segurosx.models.Seguro;
import com.segurosx.models.AgenteMediator;
import com.segurosx.models.BeneficiarioMediator;
import com.segurosx.models.ContratanteMediator;

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "type")
@JsonSubTypes({ 
  @JsonSubTypes.Type(value = AgenteMediator.class, name = "agente"), 
  @JsonSubTypes.Type(value = BeneficiarioMediator.class, name = "beneficiario"),
  @JsonSubTypes.Type(value = ContratanteMediator.class, name = "contratante")
})
public interface IMediator <T>{

    void enviaCorreoSMTP(T t,String as);

    void notify(Seguro seguro,String as);
    
    default void success(String c){
        System.out.println("Enviado correctamente a: " + c);
    }
}
