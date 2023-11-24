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
            System.out.println(dbChatroom.getIdBook() + "=/" + idBook);
            if (dbChatroom.getIdBook().equals(idBook)) {
                System.out.println("pegar do DB");
                chatroom = dbChatroom;
                break;
            } else {
                System.out.println("criar novo");
                Chatroom newChatroom = new Chatroom(idUser, idBook);
                chatroom = chatroomDAO.addNewChatroom(newChatroom);
            }
        }

        if (chatrooms.isEmpty()) {
            System.out.println("criar de lista vazia");
            Chatroom newChatroom = new Chatroom(idUser, idBook);
            chatroom = chatroomDAO.addNewChatroom(newChatroom);
        }

        System.out.println("chat no crud... idUser: " + chatroom.getIdUser());
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
