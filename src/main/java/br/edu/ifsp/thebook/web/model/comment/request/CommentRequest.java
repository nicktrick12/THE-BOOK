package br.edu.ifsp.thebook.web.model.comment.request;

import br.edu.ifsp.thebook.domain.comment.Comment;

import java.util.UUID;

public class CommentRequest {
    private UUID idUser;
    private UUID idBook;
    private String text;

    public CommentRequest(UUID idUser, UUID idBook, String text) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.text = text;
    }

    public CommentRequest() {
    }

    public Comment toComment(){
        return Comment.createFromUser(idUser, idBook, text);
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public UUID getIdBook() {
        return idBook;
    }

    public void setIdBook(UUID idBook) {
        this.idBook = idBook;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
