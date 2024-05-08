package AISS.YoutubeMiner.transformation;

import AISS.YoutubeMiner.models.channel.Channel;
import AISS.YoutubeMiner.models.videoSnippet.VideoSnippet;
import AISS.YoutubeMiner.modelsVideo.ChannelVideo.ChannelVideo;
import AISS.YoutubeMiner.modelsVideo.VideoVideo.VideoVideo;

import java.util.List;
import java.util.ArrayList;

public class ChannelTransformation {

    public static ChannelVideo transformChannel (Channel c){
        ChannelVideo channelVideo = ChannelVideo.of(
                c.getId(),
                c.getSnippet().getDescription(),
                c.getSnippet().getTitle(),
                c.getSnippet().getPublishedAt(),
                videosParse(c.getVideos()));
        return channelVideo;
    }

    public static List<VideoVideo> videosParse(List<VideoSnippet> videos){
        List<VideoVideo> videosNew = new ArrayList<VideoVideo>();
        return videos.stream().map(v->videosNew.add(VideoTransformation.transformVideo(v))).toList();
    }

}
