package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.channel.Channel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChannelServiceTest {

    @Autowired
    ChannelService channelService;

    @Test
    void searchChannel(){
        List<Channel> channel = channelService.channelSearch("Freddie Mercury");
        //assertFalse(channel==null, "Channel is empty");
        System.out.println(channel);
    }

}