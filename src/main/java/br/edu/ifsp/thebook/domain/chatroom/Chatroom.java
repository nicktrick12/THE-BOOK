package br.edu.ifsp.thebook.domain.chatroom;

import br.edu.ifsp.thebook.domain.user.Role;
import br.edu.ifsp.thebook.domain.user.Situation;
import br.edu.ifsp.thebook.domain.user.User;

import java.util.UUID;

public class Chatroom {
    private UUID id ;
    private UUID idUser;
    private UUID idBook;
    private String title;

    public Chatroom(UUID id, UUID idUser, UUID idBook, String title) {
        this.id = id;
        this.idUser = idUser;
        this.idBook = idBook;
        this.title = title;
    }

    public Chatroom(UUID idUser, UUID idBook, String title) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.title = title;
    }

    public static Chatroom createFull(UUID id, UUID idUser, UUID idBook, String title) {
        return new Chatroom(id, idUser, idBook, title);
    }

    public static Chatroom createFromChatrrom(UUID idUser, UUID idBook, String title) {
        return new Chatroom(idUser, idBook, title);
    }

    public Chatroom createWithId(UUID id) {
        return new Chatroom(id, idUser, idBook, title);
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
