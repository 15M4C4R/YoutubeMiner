package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.videoSnippet.VideoSnippet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideoServiceTest {

    @Autowired
    VideoService videoService;

    @Test
    void videoSearch() {
        List<VideoSnippet> videos = videoService.videoSearch("UCZbWTaVsdcX0lJPZRyw33sQ",10,10);
        assertFalse(videos==null, "Channel is empty");
        System.out.println(videos);
    }
}