package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.channel.Channel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChannelVideoServiceTest {

    @Autowired
    ChannelService channelService;

    @Test
    void searchChannel(){
        Channel channel = channelService.channelSearch("UCZbWTaVsdcX0lJPZRyw33sQ");
        assertFalse(channel==null, "Channel is empty");
        System.out.println(channel);
    }

}