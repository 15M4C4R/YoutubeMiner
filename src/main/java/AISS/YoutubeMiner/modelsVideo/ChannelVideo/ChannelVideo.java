package AISS.YoutubeMiner.modelsVideo.ChannelVideo;

import AISS.YoutubeMiner.modelsVideo.VideoVideo.VideoVideo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChannelVideo {
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    @JsonProperty("created_time")
    private String createdTime;

    private String id;

    private List<VideoVideo> videos;

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

    @JsonProperty("created_time")
    public String getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("created_time")
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getId() {
        List<String> aux = List.of(this.uri.split("/"));
        return aux.get(aux.size() - 1);
    }

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
        StringBuilder sb = new StringBuilder();
        sb.append(ChannelVideo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null) ? "<null>" : this.description));
        sb.append(',');
        sb.append("link");
        sb.append('=');
        sb.append(((this.createdTime == null) ? "<null>" : this.createdTime));
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    private ChannelVideo(String id,String name, String description, String created_time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdTime = created_time;
    }
    public static ChannelVideo of(String id, String name, String description, String created_time, List<VideoVideo> videoVideos){
        return new ChannelVideo(id,name,description,created_time);
    }
}
