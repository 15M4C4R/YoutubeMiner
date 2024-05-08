package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.channel.Channel;
import AISS.YoutubeMiner.models.channel.ChannelSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    VideoService videoService;

    private String token = "AIzaSyCSI0c-yBEh-9leEGPj7bpk2Yl2CjSd9XM" ;

    public Channel channelSearch(String id) {
        String uri = "https://www.googleapis.com/youtube/v3/channels?part=snippet&id="+id;
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-goog-api-key", token);
        HttpEntity<ChannelSearch> request = new HttpEntity<>(null, headers);
        ResponseEntity<ChannelSearch> response =
                restTemplate.exchange(uri, HttpMethod.GET, request, ChannelSearch.class);
        Channel channel = response.getBody().getItems().stream().findFirst().get();
        //channel.setVideos(videoService.videoSearch(channel.getId()));
        return channel;
    }

}
