package ServerRetrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostModel {
//    @SerializedName("id")
//    private String id;
//    @SerializedName("title")
//    private String title;
//    @SerializedName("created")
//    private String created;
//    @SerializedName("fulltext")
//    private String fulltext;
//    @SerializedName("img")
//    private String img;
//    public String getFulltext() {
//        return fulltext;
//    }
//    public String getCreated() {
//        return created;
//    }
//    public String getId() {
//        return id;
//    }
//    public String getTitle() {
//        return title;
//    }
//    public String getImg() {
//        return img;
//    }
//


    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("hits")
    @Expose
    private String hits;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("fulltext")
    @Expose
    private String fulltext;
    @SerializedName("catid")
    @Expose
    private String catid;
    @SerializedName("featured")
    @Expose
    private String featured;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }










}