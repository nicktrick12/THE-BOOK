package br.edu.ifsp.thebook.domain.comment;

import java.util.UUID;

public class Comment {
    private UUID id;
    private UUID idUser;
    private UUID idChatroom;
    private String text;

    public Comment(UUID id, UUID idUser, UUID idChatroom, String text) {
        this.id = id;
        this.idUser = idUser;
        this.idChatroom = idChatroom;
        this.text = text;
    }

    public Comment(UUID idUser, UUID idChatroom, String text) {
        this.idUser = idUser;
        this.idChatroom = idChatroom;
        this.text = text;
    }

    public Comment(String text) {
        this.text = text;
    }

    public static Comment createFull(UUID id, UUID idUser, UUID idChatroom, String text){
        return new Comment(id, idUser, idChatroom, text);
    }

    public static Comment createFromUser(UUID idUser, UUID idChatroom, String text){
        return new Comment(idUser, idChatroom, text);
    }

    public static Comment createWithOnlyText(String text) {
        return new Comment(text);
    }

    public Comment createWithId(UUID id){
        return new Comment(id, idUser, idChatroom, text);
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
