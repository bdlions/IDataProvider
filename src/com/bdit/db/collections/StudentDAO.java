package com.bdit.db.collections;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/**
 *
 * @author bdit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDAO implements Bson{
    private String _id;
    private String userId;
    
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Override
    public <C> BsonDocument toBsonDocument(final Class<C> documentClass, final CodecRegistry codecRegistry) {
        return new BsonDocumentWrapper<StudentDAO>(this, codecRegistry.get(StudentDAO.class));
    }
}
