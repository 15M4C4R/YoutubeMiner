package AISS.YoutubeMiner.modelsVideo.CommentVideo;

import AISS.YoutubeMiner.modelsVideo.ChannelVideo.ChannelVideo;
import AISS.YoutubeMiner.modelsVideo.UserVideo.UserVideo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CommentVideo {
    @JsonProperty("user")
    private UserVideo user;



    public UserVideo getUser() { return user; }

    public void setUser(UserVideo user) {this.user = user;}

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("id")
    private String id;

    @JsonProperty("text")
    private String text;

    @JsonProperty("publishedAt")
    private String publishedAt;

    @JsonProperty("created_on")
    private String created_on;

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("publishedAt")
    public void setPublishedAt(String publishedAt) {this.publishedAt = publishedAt; }

    @JsonProperty("created_on")
    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getId() {
        List<String> aux = List.of(uri.split("/"));
        return aux.get(aux.size()-1);
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("created_on")
    public String getCreated_on() {
        return created_on;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", created_on='" + created_on + '\'' +
                '}';
    }
    private CommentVideo(String id,String text,String publishedAt,UserVideo user) {
        this.id = id;
        this.text = text;
        this.publishedAt = publishedAt;
        this.user = user;
    }
        public static CommentVideo of(String id, String text, String publishedAt, UserVideo user) {
             return new CommentVideo(id,text,publishedAt,user);
    }
}
