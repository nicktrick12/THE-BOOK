package br.edu.ifsp.thebook.web.controller.comment;

import br.edu.ifsp.thebook.domain.comment.Comment;
import br.edu.ifsp.thebook.usecases.comment.CommentCRUD;
import br.edu.ifsp.thebook.web.model.comment.response.CommentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/comments")
@RestController
public class CommentController {
    private final CommentCRUD commentCRUD;

    public CommentController(CommentCRUD commentCRUD){
        this.commentCRUD=commentCRUD;}

    @PostMapping("/users/{idUser}/books/{idChatroom}/add")
    public ResponseEntity<CommentResponse> addComment(@PathVariable UUID idUser,
                                                      @PathVariable UUID idChatroom) {
        Comment comment = commentCRUD.registerNewComment(idUser, idChatroom);
        return ResponseEntity.ok(CommentResponse.createFromComment(comment));
    }

    @GetMapping("/users/{idUser}/books/{idChatroom}")
    public ResponseEntity<CommentResponse> findComment(@PathVariable UUID idUser,
                                                       @PathVariable UUID idChatroom) {
        Comment comment = commentCRUD.findComment(idUser, idChatroom);
        return ResponseEntity.ok(CommentResponse.createFromComment(comment));
    }
}
