package com.viewsoft.db.codec;

import com.viewsoft.db.collections.ManagingCommitteeDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import java.util.UUID;
import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/**
 *
 * @author noor
 */
public class ManagingCommitteeCodec  implements CollectibleCodec<ManagingCommitteeDAO>{
    


    private Codec<Document> documentCodec;

    public ManagingCommitteeCodec() {
        this.documentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public ManagingCommitteeDAO decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        ObjectMapper mapper = new ObjectMapper();
        ManagingCommitteeDAO managingCommitteeInfo = new ManagingCommitteeDAO();
        try {
            managingCommitteeInfo = mapper.readValue(document.toJson().toString(), ManagingCommitteeDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return managingCommitteeInfo;
    }

    @Override
    public void encode(BsonWriter writer, ManagingCommitteeDAO managingCommitteeInfo, EncoderContext encoderContext) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(managingCommitteeInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        documentCodec.encode(writer, Document.parse(json), encoderContext);
    }

    @Override
    public Class<ManagingCommitteeDAO> getEncoderClass() {
        return ManagingCommitteeDAO.class;
    }
                        
    @Override
    public ManagingCommitteeDAO generateIdIfAbsentFromDocument(ManagingCommitteeDAO managingCommitteeInfo) {
        if (!documentHasId(managingCommitteeInfo)) {
            managingCommitteeInfo.set_id(UUID.randomUUID().toString());
        }
        return managingCommitteeInfo;
    }

    @Override
    public boolean documentHasId(ManagingCommitteeDAO managingCommitteeInfo) {
        return managingCommitteeInfo.get_id() != null;
    }

    @Override
    public BsonValue getDocumentId(ManagingCommitteeDAO managingCommitteeInfo) {
        if (!documentHasId(managingCommitteeInfo)) {
            throw new IllegalStateException("The document does not contain an _id");
        }
        return new BsonString(managingCommitteeInfo.get_id());
    }
}
