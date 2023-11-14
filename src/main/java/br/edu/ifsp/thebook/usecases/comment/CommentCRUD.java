package br.edu.ifsp.thebook.usecases.comment;

import br.edu.ifsp.thebook.domain.comment.Comment;
import br.edu.ifsp.thebook.web.model.comment.request.CommentRequest;

import java.util.List;
import java.util.UUID;

public interface CommentCRUD {
    Comment registerNewComment(CommentRequest request);
    List<Comment> getAll();

    Comment getById(UUID id);

    Comment getByIdUser(UUID idUser);

    Comment getByIdChatroom(UUID idChatroom);

    Comment delete(CommentRequest request, UUID id);

    Comment registerNewComment(UUID idUser, UUID idChatroom);

    Comment findComment(UUID idUser, UUID idChatroom);
}