package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.comment.Comment;
import AISS.YoutubeMiner.models.comment.CommentSearch;
import AISS.YoutubeMiner.models.comment.CommentSnippet;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    RestTemplate restTemplate;

    private String token = "AIzaSyCSI0c-yBEh-9leEGPj7bpk2Yl2CjSd9XM" ;

    public List<Comment> commentsSearch(String videoId, Integer maxComments) {
        String uri = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&maxResults="+maxComments+"&videoId="+videoId;
        List<Comment> res = new ArrayList<Comment>();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-goog-api-key", token);
        HttpEntity<CommentSearch> request = new HttpEntity<>(null, headers);

        try{
            ResponseEntity<CommentSearch> response =
                    restTemplate.exchange(uri, HttpMethod.GET, request, CommentSearch.class);
            if(response.getBody().getItems() != null) {
                res = response.getBody().getItems();
            }
        }
        catch (HttpClientErrorException.Forbidden err) {
            if(err.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
                throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
            }
        }
        return res;
    }

}
