package AISS.YoutubeMiner.controllers;

import AISS.YoutubeMiner.modelsVideo.ChannelVideo.ChannelVideo;
import AISS.YoutubeMiner.service.ChannelService;
import AISS.YoutubeMiner.transformation.ChannelTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/youtubeminer")
public class YoutubeController {

    @Autowired
    ChannelService service;

    @Autowired
    RestTemplate restTemplate;


        final String videoMinerUri = "http://localhost:8080/api/videoMiner/videos";

    @GetMapping("/{id}")
    public ChannelVideo getChannel(@PathVariable String id,
                                   @RequestParam(required = false,defaultValue = "10") int maxVideos,
                                   @RequestParam(required = false,defaultValue = "10") int maxComments) {
        return ChannelTransformation.transformChannel(service.channelSearch(id, maxVideos, maxComments));
    }

    @PostMapping("/{id}")
    public ChannelVideo sendChannel(@PathVariable String id,  @RequestParam(required = false,defaultValue = "10") int maxVideos,
                                    @RequestParam(required = false,defaultValue = "10") int maxComments){
        ChannelVideo canal = ChannelTransformation.transformChannel(service.channelSearch(id, maxVideos, maxComments));
        HttpEntity<ChannelVideo> request = new HttpEntity<>(canal);
        ResponseEntity<ChannelVideo> response = restTemplate.exchange(videoMinerUri, HttpMethod.POST,request, ChannelVideo.class);
        return response.getBody();
    }

}
