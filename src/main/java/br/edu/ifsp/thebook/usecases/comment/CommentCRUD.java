package br.edu.ifsp.thebook.usecases.comment;

import br.edu.ifsp.thebook.domain.comment.Comment;
import br.edu.ifsp.thebook.web.model.comment.request.CommentRequest;

import java.util.List;
import java.util.UUID;

public interface CommentCRUD {
    List<Comment> getAll();

    List<Comment> getAllByChatroomId(UUID chatroomId);

    Comment getById(UUID id);

    Comment getByIdUser(UUID idUser);

    Comment delete(CommentRequest request, UUID id);

    Comment registerNewComment(UUID idUser, UUID idChatroom, CommentRequest request);
}
