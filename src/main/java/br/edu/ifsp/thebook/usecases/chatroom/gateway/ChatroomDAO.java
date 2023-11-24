package br.edu.ifsp.thebook.usecases.chatroom.gateway;

import br.edu.ifsp.thebook.domain.chatroom.Chatroom;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChatroomDAO {
    Chatroom addNewChatroom(Chatroom chatroom);
    List<Chatroom> findAll();
    Optional<Chatroom> findById(UUID id);
    Optional<Chatroom> findByIdUser(UUID idUser);
    Optional<Chatroom> findByIdBook(UUID idBook);
}
