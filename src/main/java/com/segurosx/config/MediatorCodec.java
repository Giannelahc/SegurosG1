/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.config;

import com.segurosx.models.patterns.IMediator;
import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.Document;
import org.bson.codecs.Codec;
import com.mongodb.MongoClient;
import org.bson.BsonString;

/**
 *
 * @author Giannela HC
 */
public class MediatorCodec implements CollectibleCodec<IMediator>{

    private final CodecRegistry registry;
    private final Codec<Document> documentCodec;
    private final MediatorConverter converter;

    public MediatorCodec() {
        this.registry = MongoClient.getDefaultCodecRegistry();
        this.documentCodec = this.registry.get(Document.class);
        this.converter = new MediatorConverter();
    }

    public MediatorCodec(Codec<Document> codec) {
        this.documentCodec = codec;
        this.registry = MongoClient.getDefaultCodecRegistry();
        this.converter = new MediatorConverter();
    }

    public MediatorCodec(CodecRegistry registry) {
        this.registry = registry;
        this.documentCodec = this.registry.get(Document.class);
        this.converter = new MediatorConverter();
    }
    
    
    
    @Override
    public IMediator generateIdIfAbsentFromDocument(IMediator document) {
        if (!documentHasId(document)) {
            //document.setId(new ObjectId());
        }

        return document;
    }

    @Override
    public boolean documentHasId(IMediator document) {
        return document!=null;
    }

    @Override
    public BsonValue getDocumentId(IMediator document) {
        return new BsonString(document.getClass().getSimpleName());
    }

    @Override
    public void encode(BsonWriter writer, IMediator value, EncoderContext encoderContext) {
        Document document = this.converter.convert(value);

        documentCodec.encode(writer, document, encoderContext);
    }

    @Override
    public Class<IMediator> getEncoderClass() {
        return IMediator.class;
    }

    @Override
    public IMediator decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        IMediator mediator = this.converter.convert(document);

        return mediator;
    }
    
}
