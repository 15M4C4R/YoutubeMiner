package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.channel.Channel;
import AISS.YoutubeMiner.transformation.VideoTransformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChannelServiceTest {

    @Autowired
    ChannelService channelService;

    @Test
    void searchChannel(){
        Channel channel = channelService.channelSearch("UCZbWTaVsdcX0lJPZRyw33sQ",10,10);
        assertFalse(channel==null, "Channel is empty");
        System.out.println(channel.getVideos().stream().map(v->VideoTransformation.transformVideo(v)).toList());
    }

}