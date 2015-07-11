package com.viewsoft.db.codec;

import com.viewsoft.db.collections.StaffDAO;
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
public class StaffCodec  implements CollectibleCodec<StaffDAO>{
    


    private Codec<Document> documentCodec;

    public StaffCodec() {
        this.documentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public StaffDAO decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        ObjectMapper mapper = new ObjectMapper();
        StaffDAO staffInfo = new StaffDAO();
        try {
            staffInfo = mapper.readValue(document.toJson().toString(), StaffDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staffInfo;
    }

    @Override
    public void encode(BsonWriter writer, StaffDAO staffInfo, EncoderContext encoderContext) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(staffInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        documentCodec.encode(writer, Document.parse(json), encoderContext);
    }

    @Override
    public Class<StaffDAO> getEncoderClass() {
        return StaffDAO.class;
    }
                        
    @Override
    public StaffDAO generateIdIfAbsentFromDocument(StaffDAO staffInfo) {
        if (!documentHasId(staffInfo)) {
            staffInfo.set_id(UUID.randomUUID().toString());
        }
        return staffInfo;
    }

    @Override
    public boolean documentHasId(StaffDAO staffInfo) {
        return staffInfo.get_id() != null;
    }

    @Override
    public BsonValue getDocumentId(StaffDAO staffInfo) {
        if (!documentHasId(staffInfo)) {
            throw new IllegalStateException("The document does not contain an _id");
        }
        return new BsonString(staffInfo.get_id());
    }
}
