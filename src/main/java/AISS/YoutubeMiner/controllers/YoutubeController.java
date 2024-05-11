package AISS.YoutubeMiner.controllers;

import AISS.YoutubeMiner.modelsVideo.ChannelVideo.ChannelVideo;
import AISS.YoutubeMiner.service.ChannelService;
import AISS.YoutubeMiner.transformation.ChannelTransformation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Tag(name = "Youtube", description = "Youtube management")
@RestController
@RequestMapping("/youtubeminer")
public class YoutubeController {

    @Autowired
    ChannelService service;

    @Autowired
    RestTemplate restTemplate;


        final String videoMinerUri = "http://localhost:8080/videominer/channels";


    @Operation(
            description = "Get a channel by specifying its id",
            tags = {"channel", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ChannelVideo.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema())})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ChannelVideo getChannel(@PathVariable String id,
                                   @RequestParam(required = false,defaultValue = "10") int maxVideos,
                                   @RequestParam(required = false,defaultValue = "10") int maxComments) {
        return ChannelTransformation.transformChannel(service.channelSearch(id, maxVideos, maxComments));
    }


    @Operation(
            description = "Create a channel",
            tags = {"channel", "post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = ChannelVideo.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema())})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public ChannelVideo sendChannel(@PathVariable String id,  @RequestParam(required = false,defaultValue = "10") int maxVideos,
                                    @RequestParam(required = false,defaultValue = "10") int maxComments){
        ChannelVideo canal = ChannelTransformation.transformChannel(service.channelSearch(id, maxVideos, maxComments));
        HttpEntity<ChannelVideo> request = new HttpEntity<>(canal,new HttpHeaders());
        ResponseEntity<ChannelVideo> response = restTemplate.exchange(videoMinerUri, HttpMethod.POST,request, ChannelVideo.class);
        return response.getBody();
    }

}
