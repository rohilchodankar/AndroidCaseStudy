
package com.target.dealbrowserpoc.dealbrowser.data.models;

import java.util.List;
import com.squareup.moshi.Json;

public class DealMetaData {

    @Json(name = "_id")
    private String id;
    @Json(name = "data")
    private List<Deal> deal = null;
    @Json(name = "type")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Deal> getDeal() {
        return deal;
    }

    public void setDeal(List<Deal> deal) {
        this.deal = deal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
