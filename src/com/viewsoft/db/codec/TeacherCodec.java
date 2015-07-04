package com.viewsoft.db.codec;

import com.viewsoft.db.collections.TeacherDAO;
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
public class TeacherCodec  implements CollectibleCodec<TeacherDAO>{
    


    private Codec<Document> documentCodec;

    public TeacherCodec() {
        this.documentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public TeacherDAO decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        ObjectMapper mapper = new ObjectMapper();
        TeacherDAO teacherInfo = new TeacherDAO();
        try {
            teacherInfo = mapper.readValue(document.toJson().toString(), TeacherDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return teacherInfo;
    }

    @Override
    public void encode(BsonWriter writer, TeacherDAO teacherInfo, EncoderContext encoderContext) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(teacherInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        documentCodec.encode(writer, Document.parse(json), encoderContext);
    }

    @Override
    public Class<TeacherDAO> getEncoderClass() {
        return TeacherDAO.class;
    }
                        
    @Override
    public TeacherDAO generateIdIfAbsentFromDocument(TeacherDAO teacherInfo) {
        if (!documentHasId(teacherInfo)) {
            teacherInfo.set_id(UUID.randomUUID().toString());
        }
        return teacherInfo;
    }

    @Override
    public boolean documentHasId(TeacherDAO teacherInfo) {
        return teacherInfo.get_id() != null;
    }

    @Override
    public BsonValue getDocumentId(TeacherDAO teacherInfo) {
        if (!documentHasId(teacherInfo)) {
            throw new IllegalStateException("The document does not contain an _id");
        }
        return new BsonString(teacherInfo.get_id());
    }
}
