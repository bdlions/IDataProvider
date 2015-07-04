package com.viewsoft.db.codec;

import com.viewsoft.db.collections.UserDAO;
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
 * @author bdit
 */
public class UserCodec  implements CollectibleCodec<UserDAO>{
    


    private Codec<Document> documentCodec;

    public UserCodec() {
        this.documentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public UserDAO decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        ObjectMapper mapper = new ObjectMapper();
        UserDAO userInfo = new UserDAO();
        try {
            userInfo = mapper.readValue(document.toJson().toString(), UserDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userInfo;
    }

    @Override
    public void encode(BsonWriter writer, UserDAO userInfo, EncoderContext encoderContext) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(userInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        documentCodec.encode(writer, Document.parse(json), encoderContext);
    }

    @Override
    public Class<UserDAO> getEncoderClass() {
        return UserDAO.class;
    }
                        
    @Override
    public UserDAO generateIdIfAbsentFromDocument(UserDAO userInfo) {
        if (!documentHasId(userInfo)) {
            userInfo.set_id(UUID.randomUUID().toString());
        }
        return userInfo;
    }

    @Override
    public boolean documentHasId(UserDAO userInfo) {
        return userInfo.get_id() != null;
    }

    @Override
    public BsonValue getDocumentId(UserDAO userInfo) {
        if (!documentHasId(userInfo)) {
            throw new IllegalStateException("The document does not contain an _id");
        }
        return new BsonString(userInfo.get_id());
    }
}
