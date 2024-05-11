package AISS.YoutubeMiner.modelsVideo.UserVideo;

import AISS.YoutubeMiner.models.comment.AuthorChannelId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserVideo {

    @JsonProperty("name")
    private String name;
    @JsonProperty("link")
    private String link;

    private String picture_link;

    private Long id;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
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
                ", link='" + link + '\'' +
                ", picture_link='" + picture_link + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    private UserVideo(AuthorChannelId authorChannelId, String authorDisplayName, String authorChannelUrl, String authorProfileImageUrl) {
        this.id = Long.getLong(authorChannelId.getValue());
        this.name = authorDisplayName;
        this.link = authorChannelUrl;
        this.picture_link = authorProfileImageUrl;
    }

    public static UserVideo of(AuthorChannelId authorChannelId, String authorDisplayName, String authorChannelUrl, String authorProfileImageUrl) {
        return new UserVideo(authorChannelId,authorDisplayName,authorChannelUrl,authorProfileImageUrl);
    }
}
