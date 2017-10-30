package mapp.nnp.n.testjsonfile.sampleJSONSaving;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nithin on 10/25/2017.
 */

public class DataValueItems {


    public String getItemTEXTData() {
        return itemTEXTData;
    }

    String itemTEXTData;
    private static final String itemTEXT = "Test";


    public DataValueItems(String itemTEXTData) {
        this.itemTEXTData = itemTEXTData;
    }

    public DataValueItems(JSONObject jsonObject) throws JSONException {
        itemTEXTData = jsonObject.getString(itemTEXT);

    }



    public JSONObject toJSON() throws JSONException {
        JSONObject jsonObject = new JSONObject();
            jsonObject.put(itemTEXT, itemTEXTData);


        return jsonObject;
    }

}
