package br.edu.ifsp.thebook.usecases.chatroom;

import br.edu.ifsp.thebook.domain.chatroom.Chatroom;
import br.edu.ifsp.thebook.web.model.chatroom.request.ChatroomRequest;

import java.util.List;
import java.util.UUID;

public interface ChatroomCRUD {
    Chatroom registerNewChatroom(ChatroomRequest request);
    List<Chatroom> getAllChatroom();
    Chatroom getById(UUID id);
    Chatroom getByIdUser(UUID idUser);
    Chatroom getByIdBook(UUID idBook);
    Chatroom getByTitle(String title);
}
