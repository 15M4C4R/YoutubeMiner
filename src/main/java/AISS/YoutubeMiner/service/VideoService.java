package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.videoSnippet.VideoSnippet;
import AISS.YoutubeMiner.models.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CaptionService captionService;
    @Autowired
    CommentService commentService;

    private String token = "AIzaSyCSI0c-yBEh-9leEGPj7bpk2Yl2CjSd9XM" ;

    public List<VideoSnippet> videoSearch(String channelId) {
        String uri = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&maxResults=1&channelId="+channelId;
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-goog-api-key", token);
        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null, headers);
        ResponseEntity<VideoSnippetSearch> response =
                restTemplate.exchange(uri, HttpMethod.GET, request, VideoSnippetSearch.class);
        List<VideoSnippet> videos = response.getBody().getItems();
        List<VideoSnippet> videosNew = new ArrayList<>();
        for(VideoSnippet v : videos){
            v.setCaptions(captionService.captionsSearch(v.getId().getVideoId()));
            v.setComments(commentService.commentsSearch(v.getId().getVideoId()));
            videosNew.add(v);
        }
        return videosNew;
    }

}
