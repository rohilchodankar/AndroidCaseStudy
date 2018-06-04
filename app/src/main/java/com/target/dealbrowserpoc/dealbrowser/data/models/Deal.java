
package com.target.dealbrowserpoc.dealbrowser.data.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;

public class Deal implements Parcelable{

    @Json(name = "_id")
    private String id;
    @Json(name = "aisle")
    private String aisle;
    @Json(name = "description")
    private String description;
    @Json(name = "guid")
    private String guid;
    @Json(name = "image")
    private String image;
    @Json(name = "index")
    private Integer index;
    @Json(name = "price")
    private String price;
    @Json(name = "salePrice")
    private String salePrice;
    @Json(name = "title")
    private String title;

    protected Deal(Parcel in) {
        id = in.readString();
        aisle = in.readString();
        description = in.readString();
        guid = in.readString();
        image = in.readString();
        index = in.readInt();
        price = in.readString();
        salePrice = in.readString();
        title = in.readString();
    }

    public static final Creator<Deal> CREATOR = new Creator<Deal>() {
        @Override public Deal createFromParcel(Parcel in) {
            return new Deal(in);
        }

        @Override public Deal[] newArray(int size) {
            return new Deal[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(id);
        parcel.writeString(aisle);
        parcel.writeString(description);
        parcel.writeString(guid);
        parcel.writeString(image);
        if (index == null) {
            index = 0;
        }
        parcel.writeInt(index);
        parcel.writeString(price);
        parcel.writeString(salePrice);
        parcel.writeString(title);
    }
}
