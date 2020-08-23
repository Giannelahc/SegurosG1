package com.segurosx.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoDatabase;
import com.segurosx.models.patterns.IMediator;
import com.segurosx.models.Seguro;
import org.bson.Document;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.Codec;

public class DBConnectionManager {

    private final MongoClient mongoClient;

    public DBConnectionManager() {
        this.mongoClient = new MongoClient( "localhost" , 27017 );
        //this.mongoDB = this.mongoClient.getDatabase("SRP");
    }

    public MongoDatabase getDatabase() {
        CodecRegistry codecRegistry =MongoClientSettings.getDefaultCodecRegistry();
        Codec<Document> documentCodec = codecRegistry.get(Document.class);
        Codec<IMediator> codecMediator = new MediatorCodec(codecRegistry);
        Codec<Seguro> codecSeguro = new SeguroCodec(codecRegistry);
        //CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
        codecRegistry = CodecRegistries.fromRegistries(
            codecRegistry,
//            CodecRegistries.fromProviders(
//                PojoCodecProvider.builder().automatic(true).build()
//            )
            CodecRegistries.fromCodecs(codecMediator,documentCodec,codecSeguro),//,codecSeguro
            CodecRegistries.fromProviders(
                PojoCodecProvider.builder().automatic(true).build()
            )
        );
        MongoDatabase database = this.mongoClient.getDatabase("SEGUROS").withCodecRegistry(codecRegistry);
        return database;
    }

    public void closeDatabase() {
        this.mongoClient.close();
    }

}