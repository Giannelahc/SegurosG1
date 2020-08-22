/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.repository.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.segurosx.models.Seguro;
import com.segurosx.repository.SeguroRepository;
import org.bson.types.ObjectId;

/**
 *
 * @author Giannela HC
 */
public class SeguroRepositoryImpl implements SeguroRepository{

    private static final String COLLECTION_NAME = "Seguros";

    private final MongoCollection<Seguro> Seguro;

    public SeguroRepositoryImpl(MongoDatabase database) {
        this.Seguro = database.getCollection(COLLECTION_NAME, Seguro.class);
    }
    
    @Override
    public void create(Seguro seguro) {
        System.out.println("entrando: " + seguro);        
        seguro.setNumero((new ObjectId()).toString());
        seguro.getMediator().notify(seguro, "Seguro registrado con exito");
        Seguro.insertOne(seguro);
    }
    
}
