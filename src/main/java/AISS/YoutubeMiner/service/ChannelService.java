package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.model.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;

    private String token = "";

    public Channel findOne(String id){
        Channel channel = null;
        String uri = "" + id;
        org.springframework.http.HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + this.token);
        HttpEntity<Channel> request = new HttpEntity<>(null, headers);
        ResponseEntity<Channel> response =
                restTemplate.exchange(uri, HttpMethod.GET,request,Channel.class);
        channel = response.getBody();
        channel.setVideos(); //VideoService.algo
        return channel;
    }
}
