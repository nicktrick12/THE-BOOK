package br.edu.ifsp.thebook.web.model.comment.request;

import br.edu.ifsp.thebook.domain.comment.Comment;

import java.util.UUID;

public class CommentRequest {
    private UUID idUser;
    private UUID idChatroom;
    private String text;

    public CommentRequest(UUID idUser, UUID idChatroom, String text) {
        this.idUser = idUser;
        this.idChatroom = idChatroom;
        this.text = text;
    }

    public CommentRequest() {
    }

    public Comment toComment(){
        return Comment.createFromUser(idUser, idChatroom, text);
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
