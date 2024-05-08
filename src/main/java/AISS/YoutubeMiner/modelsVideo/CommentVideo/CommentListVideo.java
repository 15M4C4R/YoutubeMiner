package AISS.YoutubeMiner.modelsVideo.CommentVideo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CommentListVideo {
    @JsonProperty("data")
    private List<CommentVideo> data;

    public List<CommentVideo> getData() {
        return data;
    }

    public void setData(List<CommentVideo> data) {
        this.data = data;
    }
}
