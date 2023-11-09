package br.edu.ifsp.thebook.web.model.comment.response;

import br.edu.ifsp.thebook.domain.comment.Comment;

import java.util.UUID;

public class CommentResponse {
    UUID id;
    UUID idUser;
    UUID idBook;
    String text;

    public CommentResponse(UUID id, UUID idUser,
                           UUID idBook, String text) {
        this.id = id;
        this.idUser = idUser;
        this.idBook = idBook;
        this.text = text;
    }

    public CommentResponse() {
    }

    public static  CommentResponse createFromComment(Comment comment){
        return new CommentResponse(
                comment.getId(),
                comment.getIdUser(),
                comment.getIdBook(),
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
