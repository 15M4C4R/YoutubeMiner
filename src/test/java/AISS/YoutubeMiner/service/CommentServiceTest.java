package AISS.YoutubeMiner.service;

import AISS.YoutubeMiner.models.comment.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Test
    void commentsSearch() {
        List<Comment> comments = commentService.commentsSearch("rRZdY6Pnz4A",10);
        assertFalse(comments==null, "Channel is empty");
        System.out.println(comments);
    }
}