/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.config;

import com.segurosx.models.EnvioMediator;
import com.segurosx.models.patterns.IMediator;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Giannela HC
 */
public class MediatorConverter {
    
    public Document convert(IMediator mediator) {
       Document document = new Document();
       document.put("_id", new ObjectId().toString());
       document.put("name", mediator.getClass().getSimpleName());

       return document;
   }
    
    public IMediator convert(Document document) {
        IMediator mediator=null;
        switch(document.getString("name")){
            case "EnvioMediator" : mediator = new EnvioMediator();
                break;
        }
        return mediator;
    }
}
