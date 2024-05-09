package AISS.YoutubeMiner.modelsVideo.CommentVideo;

import AISS.YoutubeMiner.modelsVideo.ChannelVideo.ChannelVideo;
import AISS.YoutubeMiner.modelsVideo.UserVideo.UserVideo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CommentVideo {
    @JsonProperty("user")
    private UserVideo user;

    @JsonProperty("id")
    private String id;

    @JsonProperty("text")
    private String text;

    @JsonProperty("created_on")
    private String created_on;

    public UserVideo getUser() { return user; }

    public void setUser(UserVideo user) {this.user = user;}

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("created_on")
    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getId() { return this.id;}

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
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
        this.created_on = publishedAt;
        this.user = user;
    }
        public static CommentVideo of(String id, String text, String publishedAt, UserVideo user) {
             return new CommentVideo(id,text,publishedAt,user);
    }
}
