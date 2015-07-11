package com.viewsoft.db.codec;

import com.viewsoft.db.collections.GuardianDAO;
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
public class GuardianCodec  implements CollectibleCodec<GuardianDAO>{
    


    private Codec<Document> documentCodec;

    public GuardianCodec() {
        this.documentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public GuardianDAO decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        ObjectMapper mapper = new ObjectMapper();
        GuardianDAO guardianInfo = new GuardianDAO();
        try {
            guardianInfo = mapper.readValue(document.toJson().toString(), GuardianDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return guardianInfo;
    }

    @Override
    public void encode(BsonWriter writer, GuardianDAO guardianInfo, EncoderContext encoderContext) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(guardianInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        documentCodec.encode(writer, Document.parse(json), encoderContext);
    }

    @Override
    public Class<GuardianDAO> getEncoderClass() {
        return GuardianDAO.class;
    }
                        
    @Override
    public GuardianDAO generateIdIfAbsentFromDocument(GuardianDAO guardianInfo) {
        if (!documentHasId(guardianInfo)) {
            guardianInfo.set_id(UUID.randomUUID().toString());
        }
        return guardianInfo;
    }

    @Override
    public boolean documentHasId(GuardianDAO guardianInfo) {
        return guardianInfo.get_id() != null;
    }

    @Override
    public BsonValue getDocumentId(GuardianDAO guardianInfo) {
        if (!documentHasId(guardianInfo)) {
            throw new IllegalStateException("The document does not contain an _id");
        }
        return new BsonString(guardianInfo.get_id());
    }
}
