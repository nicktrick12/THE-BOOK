package br.edu.ifsp.thebook.usecases.chatroom;

import br.edu.ifsp.thebook.domain.chatroom.Chatroom;
import br.edu.ifsp.thebook.usecases.chatroom.gateway.ChatroomDAO;
import br.edu.ifsp.thebook.web.model.chatroom.request.ChatroomRequest;

import java.util.List;
import java.util.UUID;

public class ChatroomCRUDImpl implements ChatroomCRUD{

    private final ChatroomDAO chatroomDAO;

    public ChatroomCRUDImpl(ChatroomDAO chatroomDAO) {
        this.chatroomDAO = chatroomDAO;}
    @Override
    public Chatroom registerNewChatroom(ChatroomRequest request) {
        Chatroom chatroom = request.toChatroom();
        return chatroomDAO.addNewChatroom(chatroom);
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

    @Override
    public Chatroom getByTitle(String title) {
        Chatroom chatroom  = chatroomDAO.findByTitle(title).get();
        return chatroom;
    }


}
