package br.edu.ifsp.thebook.usecases.chatroom;

import br.edu.ifsp.thebook.domain.chatroom.Chatroom;

import java.util.List;
import java.util.UUID;

public interface ChatroomCRUD {
    Chatroom registerNewChatroom(UUID idUser, UUID idBook);
    List<Chatroom> getAllChatroom();
    Chatroom getById(UUID id);
    Chatroom getByIdUser(UUID idUser);
    Chatroom getByIdBook(UUID idBook);
}
