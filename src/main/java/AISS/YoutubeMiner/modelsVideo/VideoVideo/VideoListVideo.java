package AISS.YoutubeMiner.modelsVideo.VideoVideo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class VideoListVideo {
    @JsonProperty("data")
    private List<VideoVideo> data;

    public List<VideoVideo> getData() {
        return data;
    }

    public void setData(List<VideoVideo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "VideoList{" +
                "data=" + data +
                '}';
    }
}
