package AISS.YoutubeMiner.transformation;

import AISS.YoutubeMiner.models.caption.Caption;
import AISS.YoutubeMiner.models.comment.Comment;
import AISS.YoutubeMiner.models.videoSnippet.VideoSnippet;
import AISS.YoutubeMiner.modelsVideo.CaptionVideo.CaptionVideo;
import AISS.YoutubeMiner.modelsVideo.CommentVideo.CommentVideo;
import AISS.YoutubeMiner.modelsVideo.VideoVideo.VideoVideo;

import java.util.List;

public class VideoTransformation {

    public static VideoVideo transformVideo (VideoSnippet v){
        return VideoVideo.of(
                v.getId().getVideoId(),
                v.getSnippet().getTitle(),
                v.getSnippet().getDescription(),
                v.getSnippet().getPublishedAt(),
                captionsParse(v.getCaptions()),
                commentParse(v.getComments())
        );
    }

    public static List<CaptionVideo> captionsParse (List<Caption> c){
        return c.stream().map(cap->CaptionTransformation.transformCaption(cap)).toList();
    }

    public static List<CommentVideo> commentParse(List<Comment> c){
        return c.stream().map(com->CommentTransformation.transformComment(com)).toList();
    }



}
