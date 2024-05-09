package AISS.YoutubeMiner.transformation;

import AISS.YoutubeMiner.models.comment.Comment;
import AISS.YoutubeMiner.modelsVideo.CommentVideo.CommentVideo;
import AISS.YoutubeMiner.modelsVideo.UserVideo.UserVideo;

public class CommentTransformation {


    public static CommentVideo transformComment(Comment com) {
        return CommentVideo.of(
                com.getCommentSnippet().getTopLevelComment().getId(),
                com.getCommentSnippet().getTopLevelComment().getSnippet().getTextOriginal(),
                com.getCommentSnippet().getTopLevelComment().getSnippet().getPublishedAt(),
                transformUser(com)
        );
    }

    public static UserVideo transformUser(Comment com) {
        return UserVideo.of(
                com.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorChannelId(),
                com.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorDisplayName(),
                com.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorChannelUrl(),
                com.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorProfileImageUrl()
        );
    }



}
