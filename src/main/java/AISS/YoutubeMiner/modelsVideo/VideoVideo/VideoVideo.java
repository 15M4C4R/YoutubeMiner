package AISS.YoutubeMiner.modelsVideo.VideoVideo;

import AISS.YoutubeMiner.models.comment.AuthorChannelId;
import AISS.YoutubeMiner.modelsVideo.CaptionVideo.CaptionVideo;
import AISS.YoutubeMiner.modelsVideo.CommentVideo.CommentVideo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class VideoVideo {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    @JsonProperty("release_time")
    private String releaseTime;
    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("publishedAt")
    private String publishedAt;
    @JsonProperty("captionVideos")
    private List<CaptionVideo> captionVideos;
    @JsonProperty("commentVideos")
    private List<CommentVideo> commentVideos;

    private String id;


    public List<CaptionVideo> getCaptions() {
        return captions;
    }

    public void setCaptions(List<CaptionVideo> captions) {
        this.captions = captions;
    }

    public void setComments(List<CommentVideo> comments) {
        this.comments = comments;
    }

    public List<CommentVideo> getComments() {
        return comments;
    }

    private List<CaptionVideo> captions;

    private List<CommentVideo> comments;

    public String getId() {
        List<String> aux = List.of(this.uri.split("/"));
        return aux.get(aux.size()-1);
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getVideoId() {return videoId; }

    @JsonProperty("name")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("name")
    public String getTitle() {
        return title;
    }

    @JsonProperty("name")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("name")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("name")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonProperty("name")
    public List<CaptionVideo> getCaptionVideos() {
        return captionVideos;
    }

    @JsonProperty("name")
    public void setCaptionVideos(List<CaptionVideo> captionVideos) {
        this.captionVideos = captionVideos;
    }

    @JsonProperty("name")
    public List<CommentVideo> getCommentVideos() {
        return commentVideos;
    }

    @JsonProperty("name")
    public void setCommentVideos(List<CommentVideo> commentVideos) {
        this.commentVideos = commentVideos;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("release_time")
    public String getReleaseTime() {
        return releaseTime;
    }

    @JsonProperty("release_time")
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VideoVideo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("releaseTime");
        sb.append('=');
        sb.append(((this.releaseTime == null)?"<null>":this.releaseTime));
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    private VideoVideo(String videoId, String title, String description, String publishedAt,  List<CaptionVideo> captionVideos, List<CommentVideo> commentVideos) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.publishedAt= publishedAt;
        this.captionVideos = captionVideos;
        this.commentVideos = commentVideos;

    }

    public static VideoVideo of(String videoId, String title, String description, String publishedAt, List<CaptionVideo> captionVideos, List<CommentVideo> commentVideos) {
        return new VideoVideo(videoId,title,description,publishedAt,captionVideos,commentVideos);
    }

}
