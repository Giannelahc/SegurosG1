package com.segurosx.models.patterns;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.segurosx.models.Seguro;
import com.segurosx.models.EnvioMediator;
//para mostrar context.json (serializar)
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "type")
@JsonSubTypes({ 
  @JsonSubTypes.Type(value = EnvioMediator.class, name = "envioMediator")
})
public interface IMediator <T>{

    void enviaCorreoSMTP(T t,String as);

    void notify(Seguro seguro,String as);
    
    default void success(String c){
        System.out.println("Enviado correctamente a: " + c);
    }
}
