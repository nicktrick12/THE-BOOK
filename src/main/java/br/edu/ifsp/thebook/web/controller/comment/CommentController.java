package br.edu.ifsp.thebook.web.controller.comment;

import br.edu.ifsp.thebook.domain.comment.Comment;
import br.edu.ifsp.thebook.usecases.comment.CommentCRUD;
import br.edu.ifsp.thebook.web.model.comment.request.CommentRequest;
import br.edu.ifsp.thebook.web.model.comment.response.CommentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/comments")
@RestController
public class CommentController {
    private final CommentCRUD commentCRUD;

    public CommentController(CommentCRUD commentCRUD){
        this.commentCRUD=commentCRUD;}

    @PostMapping("/users/{idUser}/chatrooms/{idChatroom}/add")
    public ResponseEntity<CommentResponse> addComment(@PathVariable UUID idUser,
                                                      @PathVariable UUID idChatroom,
                                                      @RequestBody CommentRequest request) {
        Comment comment = commentCRUD.registerNewComment(idUser, idChatroom, request);
        return ResponseEntity.ok(CommentResponse.createFromComment(comment));
    }

    @GetMapping("/chatrooms/{idChatroom}")
    public ResponseEntity<List<CommentResponse>> findComments( @PathVariable UUID idChatroom) {
        List <Comment> comments = commentCRUD.getAllByChatroomId(idChatroom);

        return ResponseEntity.ok(
                comments.stream()
                        .map(CommentResponse::createFromComment)
                        .collect(java.util.stream.Collectors.toList())
        );
    }
}
