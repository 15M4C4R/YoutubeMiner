package AISS.YoutubeMiner.modelsVideo.VideoVideo;

import AISS.YoutubeMiner.models.comment.AuthorChannelId;
import AISS.YoutubeMiner.modelsVideo.CaptionVideo.CaptionVideo;
import AISS.YoutubeMiner.modelsVideo.CommentVideo.CommentVideo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class VideoVideo {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    @JsonProperty("releaseTime")
    private String releaseTime;

    @JsonProperty("captions")
    private List<CaptionVideo> captions;
    @JsonProperty("comments")
    private List<CommentVideo> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public List<CaptionVideo> getCaptionVideos() {
        return captions;
    }

    public void setCaptionVideos(List<CaptionVideo> captionVideos) {
        this.captions = captionVideos;
    }

    public List<CommentVideo> getCommentVideos() {
        return comments;
    }

    public void setCommentVideos(List<CommentVideo> commentVideos) {
        this.comments = commentVideos;
    }

    @Override
    public String toString() {
        return "VideoVideo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", captionVideos=" + captions +
                ", commentVideos=" + comments +
                '}';
    }

    private VideoVideo(String videoId, String title, String description, String publishedAt, List<CaptionVideo> captionVideos, List<CommentVideo> commentVideos) {
        this.id = videoId;
        this.name = title;
        this.description = description;
        this.releaseTime= publishedAt;
        this.captions = captionVideos;
        this.comments = commentVideos;

    }

    public static VideoVideo of(String videoId, String title, String description, String publishedAt, List<CaptionVideo> captionVideos, List<CommentVideo> commentVideos) {
        return new VideoVideo(videoId,title,description,publishedAt,captionVideos,commentVideos);
    }

}
