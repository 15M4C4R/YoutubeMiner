package AISS.YoutubeMiner.modelsVideo.UserVideo;

import AISS.YoutubeMiner.models.comment.AuthorChannelId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserVideo {
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("link")
    private String link;
    //private String user_link = getLink();
    @JsonProperty("pictures")
    private PicturesVideo pictures;
    @JsonProperty("authorChannelId")
    private AuthorChannelId authorChannelId;
    @JsonProperty("authorDisplayName")
    private String authorDisplayName;
    @JsonProperty("authorChannelUrl")
    private String authorChannelUrl;
    @JsonProperty("authorProfileImageUrl")
    private String authorProfileImageUrl;

    private String picture_link;

    private String id;





    @JsonProperty("authorChannelId")
    public AuthorChannelId getAuthorChannelId() {
        return authorChannelId;
    }

    @JsonProperty("authorChannelId")
    public void setAuthorChannelId(AuthorChannelId authorChannelId) {this.authorChannelId = authorChannelId;}

    @JsonProperty("authorDisplayName")
    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    @JsonProperty("authorDisplayName")
    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    @JsonProperty("authorChannelUrl")
    public String getAuthorChannelUrl() {
        return authorChannelUrl;
    }

    @JsonProperty("authorChannelUrl")
    public void setAuthorChannelUrl(String authorChannelUrl) {
        this.authorChannelUrl = authorChannelUrl;
    }

    @JsonProperty("authorProfileImageUrl")
    public String getAuthorProfileImageUrl() {
        return authorProfileImageUrl;
    }

    @JsonProperty("authorProfileImageUrl")
    public void setAuthorProfileImageUrl(String authorProfileImageUrl) {this.authorProfileImageUrl = authorProfileImageUrl; }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

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

    @JsonProperty("pictures")
    public PicturesVideo getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(PicturesVideo pictures) {
        this.pictures = pictures;
    }

    public String getId() {
        List<String> aux = List.of(this.uri.split("/"));
        return aux.get(aux.size()-1);
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPicture_link() {
        return pictures.getBaseLink();
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UserVideo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("link");
        sb.append('=');
        sb.append(((this.link == null)?"<null>":this.link));
        sb.append(',');
        sb.append("pictures");
        sb.append('=');
        sb.append(((this.pictures == null)?"<null>":this.pictures));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    private UserVideo(AuthorChannelId authorChannelId, String authorDisplayName, String authorChannelUrl, String authorProfileImageUrl) {
        this.authorChannelId = authorChannelId;
        this.authorDisplayName = authorDisplayName;
        this.authorChannelUrl = authorChannelUrl;
        this.authorProfileImageUrl = authorProfileImageUrl;
    }

    public static UserVideo of(AuthorChannelId authorChannelId, String authorDisplayName, String authorChannelUrl, String authorProfileImageUrl) {
        return new UserVideo(authorChannelId,authorDisplayName,authorChannelUrl,authorProfileImageUrl);
    }
}
