package com.segurosx.models.patterns;

import com.segurosx.models.Seguro;

public interface IMediator <T>{


    void enviaCorreoSMTP(T t);

    void notify(Seguro seguro);
    
    default void success(String c){
        System.out.println("Enviado correctamente a: " + c);
    }
}
