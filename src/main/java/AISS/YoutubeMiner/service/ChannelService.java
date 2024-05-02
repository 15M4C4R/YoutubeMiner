package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.channel.ChannelSearch;
import AISS.YoutubeMiner.models.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;

    private  String token = "AIzaSyCSI0c-yBEh-9leEGPj7bpk2Yl2CjSd9XM";

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




}
