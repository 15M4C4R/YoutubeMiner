package AISS.YoutubeMiner.modelsVideo.ChannelVideo;

import AISS.YoutubeMiner.modelsVideo.VideoVideo.VideoVideo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChannelVideo {

    private String id;

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    @JsonProperty("created_time")
    private String createdTime;

    private List<VideoVideo> videos;

    @JsonProperty("name")
    public String getName() {
        return this.name;
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

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getId() { return this.id;}

    public void setId(String id) {
        this.id = id;
    }

    public List<VideoVideo> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoVideo> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "ChannelVideo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", videos=" + videos +
                '}';
    }

    private ChannelVideo(String id, String name, String description, String created_time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdTime = created_time;
    }
    public static ChannelVideo of(String id, String name, String description, String created_time, List<VideoVideo> videoVideos){
        return new ChannelVideo(id,name,description,created_time);
    }
}
