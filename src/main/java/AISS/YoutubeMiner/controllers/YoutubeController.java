package AISS.YoutubeMiner.controllers;

import AISS.YoutubeMiner.modelsVideo.ChannelVideo.ChannelVideo;
import AISS.YoutubeMiner.service.ChannelService;
import AISS.YoutubeMiner.transformation.ChannelTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/youtubeminer")
public class YoutubeController {

    @Autowired
    ChannelService service;


    final String videoMinerUri = "http://localhost:8080/api/videoMiner/videos";

    @GetMapping("/{id}")
    public ChannelVideo getChannel(@PathVariable String id,
                                   @RequestParam(required = false,defaultValue = "10") int maxVideos,
                                   @RequestParam(required = false,defaultValue = "10") int maxComments) {
        return ChannelTransformation.transformChannel(service.channelSearch(id, maxVideos, maxComments));
    }



}
