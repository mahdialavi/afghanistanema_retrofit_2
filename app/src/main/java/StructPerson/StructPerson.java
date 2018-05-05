package StructPerson;


import com.google.gson.annotations.SerializedName;

public class StructPerson {
    @SerializedName("id")
public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("fulltext")
    public String fulltext;
    @SerializedName("introtext")
    public String introtext;
    @SerializedName("featured")
    public boolean featured;
    @SerializedName("hits")
    public String hits;
    @SerializedName("created")
    public String created;
    @SerializedName("catid")
    public String catid;
    @SerializedName("stored")
    public boolean stored;

    public void setCreated(String created) {
        this.created = created;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public String getImg() {
        return introtext;
    }

    public void setImg(String img) {
        this.introtext= introtext;
    }


    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public Boolean getStored() {
        return stored;
    }
    public void setStored(Boolean stored) {
        this.stored = stored;
    }
    public Boolean getFeatured() {
        return featured;
    }
    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }
}
