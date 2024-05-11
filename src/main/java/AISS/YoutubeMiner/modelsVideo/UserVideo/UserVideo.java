package AISS.YoutubeMiner.modelsVideo.UserVideo;

import AISS.YoutubeMiner.models.comment.AuthorChannelId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserVideo {

    @JsonProperty("name")
    private String name;
    @JsonProperty("user_link")
    private String user_link;

    @JsonProperty("")
    private String picture_link;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("user_link")
    public String getUserLink() {
        return user_link;
    }

    @JsonProperty("link")
    public void setUserLink(String link) {
        this.user_link = link;
    }

    public String getPicture_link() {
        return this.picture_link;
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }

    @Override
    public String toString() {
        return "UserVideo{" +
                "name='" + name + '\'' +
                ", user_link='" + user_link + '\'' +
                ", picture_link='" + picture_link + '\'' +
                '}';
    }

    private UserVideo(String authorDisplayName, String authorChannelUrl, String authorProfileImageUrl) {
        this.name = authorDisplayName;
        this.user_link = authorChannelUrl;
        this.picture_link = authorProfileImageUrl;
    }

    public static UserVideo of(String authorDisplayName, String authorChannelUrl, String authorProfileImageUrl) {
        return new UserVideo(authorDisplayName,authorChannelUrl,authorProfileImageUrl);
    }
}
