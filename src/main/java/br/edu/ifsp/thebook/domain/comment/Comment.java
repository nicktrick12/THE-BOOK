package br.edu.ifsp.thebook.domain.comment;

import java.util.UUID;

public class Comment {
    private UUID id;
    private UUID idUser;
    private UUID idBook;
    private String text;

    public Comment(UUID id, UUID idUser, UUID idBook, String text) {
        this.id = id;
        this.idUser = idUser;
        this.idBook = idBook;
        this.text = text;
    }

    public Comment(UUID idUser, UUID idBook, String text) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.text = text;
    }

    public static Comment createFull(UUID id, UUID idUser, UUID idBook, String text){
        return new Comment(id, idUser, idBook, text);
    }

    public static Comment createFromUser(UUID idUser, UUID idBook, String text){
        return new Comment(idUser, idBook, text);
    }

    public Comment createWithId(UUID id){
        return new Comment(id, idUser, idBook, text);
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
