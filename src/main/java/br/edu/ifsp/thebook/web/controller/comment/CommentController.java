package br.edu.ifsp.thebook.web.controller.comment;

import br.edu.ifsp.thebook.domain.comment.Comment;
import br.edu.ifsp.thebook.domain.reading.Reading;
import br.edu.ifsp.thebook.usecases.comment.CommentCRUD;
import br.edu.ifsp.thebook.web.model.comment.request.CommentRequest;
import br.edu.ifsp.thebook.web.model.comment.response.CommentResponse;
import br.edu.ifsp.thebook.web.model.reading.request.ReadingUpdateRequest;
import br.edu.ifsp.thebook.web.model.reading.response.ReadingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/comments")
@RestController
public class CommentController {
    private final CommentCRUD commentCRUD;

    public CommentController(CommentCRUD commentCRUD){
        this.commentCRUD=commentCRUD;}

    @PostMapping("/users/{idUser}/books/{idBook}/add")
    public ResponseEntity<CommentResponse> addComment(@PathVariable UUID idUser,
                                                      @PathVariable UUID idBook) {
        Comment comment = commentCRUD.registerNewComment(idUser, idBook);
        return ResponseEntity.ok(CommentResponse.createFromComment(comment));
    }

    @GetMapping("/users/{idUser}/books/{idBook}")
    public ResponseEntity<CommentResponse> findComment(@PathVariable UUID idUser,
                                                       @PathVariable UUID idBook) {
        Comment comment = commentCRUD.findComment(idUser, idBook);
        return ResponseEntity.ok(CommentResponse.createFromComment(comment));
    }
}
