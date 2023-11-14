package br.edu.ifsp.thebook.web.model.chatroom.response;

import br.edu.ifsp.thebook.domain.chatroom.Chatroom;

import java.util.UUID;

public class ChatroomResponse {
    UUID id;
    UUID idUser;
    UUID idBook;
    String title;

    public ChatroomResponse(UUID id, UUID idUser, UUID idBook, String title) {
        this.id = id;
        this.idUser = idUser;
        this.idBook = idBook;
        this.title = title;
    }

    public ChatroomResponse() {
    }

    public static ChatroomResponse createFromChatroom(Chatroom chatroom) {
        return new ChatroomResponse(
                chatroom.getId(),
                chatroom.getIdUser(),
                chatroom.getIdBook(),
                chatroom.getTitle()
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
