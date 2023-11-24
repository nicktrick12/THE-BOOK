package br.edu.ifsp.thebook.usecases.comment.gateway;

import br.edu.ifsp.thebook.domain.comment.Comment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentDAO {
    Comment addNewComment(Comment comment);
    List<Comment> findAll();
    Optional<Comment> findById(UUID id);
    Optional<Comment> findByIdUser(UUID idUser);
    List<Comment> findAllByIdChatroom(UUID idChatroom);
    Comment delete(Comment comment);
    Boolean commentExists(UUID commentId);
}
