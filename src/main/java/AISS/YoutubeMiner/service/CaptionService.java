package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.caption.Caption;
import AISS.YoutubeMiner.models.caption.CaptionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CaptionService {

    @Autowired
    RestTemplate restTemplate;

    private String token = "AIzaSyCSI0c-yBEh-9leEGPj7bpk2Yl2CjSd9XM" ;

    public List<Caption> captionsSearch(String idVideo) {
        String uri = "https://www.googleapis.com/youtube/v3/captions?part=snippet&videoId="+idVideo;
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-goog-api-key", token);
        HttpEntity<CaptionSearch> request = new HttpEntity<>(null, headers);
        ResponseEntity<CaptionSearch> response =
                restTemplate.exchange(uri, HttpMethod.GET, request, CaptionSearch.class);
        return response.getBody().getItems();
    }

}
