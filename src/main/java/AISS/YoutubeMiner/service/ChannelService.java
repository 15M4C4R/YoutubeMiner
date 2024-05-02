package AISS.YoutubeMiner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;


    public List<Channel> channelSearch(String name){
        ChannelSearch channels = null;
        String uri = "https://www.googleapis.com/youtube/v3/search/?key="+this.token+"&part=snippet&q="
                + name + "&type=channel&maxResults=10";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ChannelSearch> request = new HttpEntity<>(null,null);
        ResponseEntity<ChannelSearch> response =
                restTemplate.exchange(uri, HttpMethod.GET,request,ChannelSearch.class);
        channels = response.getBody();
        System.out.println(channels);
        return channels.getItems();
        }
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
