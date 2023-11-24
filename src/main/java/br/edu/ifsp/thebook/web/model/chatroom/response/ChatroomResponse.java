package br.edu.ifsp.thebook.web.model.chatroom.response;

import br.edu.ifsp.thebook.domain.chatroom.Chatroom;

import java.util.UUID;

public class ChatroomResponse {
    UUID id;
    UUID idUser;
    UUID idBook;

    public ChatroomResponse(UUID id, UUID idUser, UUID idBook) {
        this.id = id;
        this.idUser = idUser;
        this.idBook = idBook;
    }

    public ChatroomResponse() {
    }

    public static ChatroomResponse createFromChatroom(Chatroom chatroom) {
        return new ChatroomResponse(
                chatroom.getId(),
                chatroom.getIdUser(),
                chatroom.getIdBook()
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
}
