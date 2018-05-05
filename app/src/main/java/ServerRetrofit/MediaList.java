package ServerRetrofit;

import com.google.gson.annotations.SerializedName;

public class MediaList {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("source")
    private String source;
    @SerializedName("created")
    private String created;
    @SerializedName("description")
    private String description;
    @SerializedName("img")
    private String img;

    public void setImage(String img) {
        this.img = img;
    }

    public String getImage() {
        return img;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String img) {
        this.source = img;
    }
}