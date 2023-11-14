package br.edu.ifsp.thebook.web.model.comment.response;

import br.edu.ifsp.thebook.domain.comment.Comment;

import java.util.UUID;

public class CommentResponse {
    UUID id;
    UUID idUser;
    UUID idChatroom;
    String text;

    public CommentResponse(UUID id, UUID idUser,
                           UUID idChatroom, String text) {
        this.id = id;
        this.idUser = idUser;
        this.idChatroom = idChatroom;
        this.text = text;
    }

    public CommentResponse() {
    }

    public static  CommentResponse createFromComment(Comment comment){
        return new CommentResponse(
                comment.getId(),
                comment.getIdUser(),
                comment.getIdChatroom(),
                comment.getText()
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public UUID getIdChatroom() {
        return idChatroom;
    }

    public void setIdChatroom(UUID idChatroom) {
        this.idChatroom = idChatroom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
