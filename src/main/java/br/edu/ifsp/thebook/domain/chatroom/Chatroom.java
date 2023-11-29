package br.edu.ifsp.thebook.domain.chatroom;

import br.edu.ifsp.thebook.domain.user.Role;
import br.edu.ifsp.thebook.domain.user.Situation;
import br.edu.ifsp.thebook.domain.user.User;

import java.util.UUID;

public class Chatroom {
    private UUID id;
    private UUID idUser;
    private UUID idBook;

    public Chatroom(UUID id, UUID idUser, UUID idBook) {
        this.id = id;
        this.idUser = idUser;
        this.idBook = idBook;
    }

    public Chatroom(UUID idUser, UUID idBook) {
        this.idUser = idUser;
        this.idBook = idBook;
    }

    public static Chatroom createFull(UUID id, UUID idUser, UUID idBook) {
        return new Chatroom(id, idUser, idBook);
    }

    public static Chatroom createFromChatroom(UUID idUser, UUID idBook) {
        return new Chatroom(idUser, idBook);
    }

    public Chatroom createWithId(UUID id) {
        return new Chatroom(id, idUser, idBook);
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
