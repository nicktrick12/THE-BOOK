package br.edu.ifsp.thebook.web.model.chatroom.request;


import br.edu.ifsp.thebook.domain.chatroom.Chatroom;

import java.util.UUID;

public class ChatroomRequest {
    private UUID idUser;
    private UUID idBook;
    private String title;
    public ChatroomRequest(UUID idUser, UUID idBook, String title) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.title = title;
    }
    public Chatroom toChatroom(){
        return Chatroom.createFromChatrrom(idUser,idBook,title);
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
