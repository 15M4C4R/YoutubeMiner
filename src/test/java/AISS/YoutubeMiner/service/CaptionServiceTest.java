package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.caption.Caption;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CaptionServiceTest {

    @Autowired
    CaptionService captionService;

    @Test
    void captionsSearch() {
        List<Caption> captions = captionService.captionsSearch("dQw4w9WgXcQ");
        assertFalse(captions==null, "Captions is empty");
        System.out.println(captions);
    }
}