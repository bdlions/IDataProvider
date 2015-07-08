package com.viewsoft.db.collections.fragment;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *
 * @author nazmul hasan
 */
public class BloodGroup {

    private String _id;
    private String title;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return json;
    }
    
    
    public static BloodGroup getBloodGroup(String jsonContent){
        BloodGroup bloodGroup = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            bloodGroup = mapper.readValue(jsonContent, BloodGroup.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bloodGroup;
    }

}
