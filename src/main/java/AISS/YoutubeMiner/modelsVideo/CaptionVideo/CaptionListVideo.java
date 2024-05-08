package AISS.YoutubeMiner.modelsVideo.CaptionVideo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class CaptionListVideo {
    @JsonProperty("data")
    private List<CaptionVideo> data;

    public List<CaptionVideo> getData() { return data;}

    public void setData(List<CaptionVideo> data) { this.data = data;}

}
