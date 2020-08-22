/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segurosx.config;

import com.segurosx.models.Seguro;
import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;
import com.mongodb.MongoClient;
import org.bson.BsonString;
import org.bson.codecs.Codec;
/**
 *
 * @author Giannela HC
 */
public class SeguroCodec implements CollectibleCodec<Seguro>{

    private final CodecRegistry registry;
    private final Codec<Document> documentCodec;
    private final MediatorConverter itemConverter;

    public SeguroCodec() {
        this.registry = MongoClient.getDefaultCodecRegistry();
        this.documentCodec = this.registry.get(Document.class);
        this.itemConverter = new MediatorConverter();
    }

    public SeguroCodec(CodecRegistry registry) {
        this.registry = registry;
        this.documentCodec = this.registry.get(Document.class);
        this.itemConverter = new MediatorConverter();
    }

    public SeguroCodec( Codec<Document> codec) {
        this.registry = MongoClient.getDefaultCodecRegistry();
        this.documentCodec = codec;
        this.itemConverter = new MediatorConverter();
    }
    
    @Override
    public Seguro generateIdIfAbsentFromDocument(Seguro document) {
        return document;
    }

    @Override
    public boolean documentHasId(Seguro document) {
        return document!=null;
    }

    @Override
    public BsonValue getDocumentId(Seguro document) {
        return new BsonString(document.getClass().getSimpleName());
    }

    @Override
    public void encode(BsonWriter writer, Seguro value, EncoderContext encoderContext) {
        Document document = new Document();
        document.put("numero", value.getNumero());
        document.put("agente", value.getAgente());
        document.put("beneficiarios", value.getBeneficiarios());
        document.put("certificado", value.getCertificado());
        document.put("contratante", value.getContratante());
        document.put("marca", value.getMarca());
        document.put("modelo", value.getModelo());
        document.put("nivelRiesgo", value.getNivelRiesgo());
        document.put("poliza", value.getPoliza());
        document.put("mediator", value.getMediator().getClass().getSimpleName());

        documentCodec.encode(writer, document, encoderContext);
    }

    @Override
    public Class<Seguro> getEncoderClass() {
        return Seguro.class;
    }

    @Override
    public Seguro decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        Seguro order = null;
//        new Seguro() ;
//
//        ArrayList<Document> docArr = (ArrayList) document.get("items");
//        for (Document doc : docArr) {
//            Item item = this.itemConverter.convert(doc);
//            order.addItem(item);
//        }

        return order;
    }
    
}
