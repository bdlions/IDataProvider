package com.bdit.db.codec;

import com.bdit.db.collections.StudentDAO;
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
public class StudentCodec  implements CollectibleCodec<StudentDAO>{
    


    private Codec<Document> documentCodec;

    public StudentCodec() {
        this.documentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public StudentDAO decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        ObjectMapper mapper = new ObjectMapper();
        StudentDAO studentInfo = new StudentDAO();
        try {
            studentInfo = mapper.readValue(document.toJson().toString(), StudentDAO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return studentInfo;
    }

    @Override
    public void encode(BsonWriter writer, StudentDAO studentInfo, EncoderContext encoderContext) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(studentInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        documentCodec.encode(writer, Document.parse(json), encoderContext);
    }

    @Override
    public Class<StudentDAO> getEncoderClass() {
        return StudentDAO.class;
    }
                        
    @Override
    public StudentDAO generateIdIfAbsentFromDocument(StudentDAO studentInfo) {
        if (!documentHasId(studentInfo)) {
            studentInfo.set_id(UUID.randomUUID().toString());
        }
        return studentInfo;
    }

    @Override
    public boolean documentHasId(StudentDAO studentInfo) {
        return studentInfo.get_id() != null;
    }

    @Override
    public BsonValue getDocumentId(StudentDAO studentInfo) {
        if (!documentHasId(studentInfo)) {
            throw new IllegalStateException("The document does not contain an _id");
        }
        return new BsonString(studentInfo.get_id());
    }
}
