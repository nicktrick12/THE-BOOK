package br.edu.ifsp.thebook.usecases.chatroom;

import br.edu.ifsp.thebook.domain.chatroom.Chatroom;
import br.edu.ifsp.thebook.usecases.chatroom.gateway.ChatroomDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatroomCRUDImpl implements ChatroomCRUD{

    private final ChatroomDAO chatroomDAO;

    public ChatroomCRUDImpl(ChatroomDAO chatroomDAO) {
        this.chatroomDAO = chatroomDAO;}
    @Override
    public Chatroom registerNewChatroom(UUID idUser, UUID idBook) {
        List<Chatroom> chatrooms = getAllChatroom();
        Chatroom chatroom = null;
        for (Chatroom dbChatroom : chatrooms) {
            if (dbChatroom.getIdBook() == idBook) {
                chatroom = dbChatroom;
            } else {
                Chatroom newChatroom = new Chatroom(idUser, idBook);
                chatroom = chatroomDAO.addNewChatroom(newChatroom);
            }
        }
        return chatroom;
    }

    @Override
    public List<Chatroom> getAllChatroom() {
        List<Chatroom> chatrooms = chatroomDAO.findAll();
        return chatrooms;
    }

    @Override
    public Chatroom getById(UUID id){
        Chatroom chatroom  = chatroomDAO.findById(id).get();
        return chatroom;
    }

    @Override
    public Chatroom getByIdUser(UUID idUser) {
        Chatroom chatroom  = chatroomDAO.findById(idUser).get();
        return chatroom;
    }

    @Override
    public Chatroom getByIdBook(UUID idBook) {
        Chatroom chatroom  = chatroomDAO.findById(idBook).get();
        return chatroom;
    }

}
