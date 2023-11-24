package br.edu.ifsp.thebook.web.controller.chatroom;

import br.edu.ifsp.thebook.domain.chatroom.Chatroom;
import br.edu.ifsp.thebook.usecases.chatroom.ChatroomCRUD;
import br.edu.ifsp.thebook.web.model.chatroom.response.ChatroomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/chatrooms")
@RestController
public class ChatroomController {
    private final ChatroomCRUD chatroomCRUD;
    public ChatroomController(ChatroomCRUD chatroomCRUD ) {
        this.chatroomCRUD=chatroomCRUD;
    }
    @PostMapping("/users/{idUser}/books/{idBook}/add")
    public ResponseEntity<ChatroomResponse> createChatroom(@PathVariable UUID idUser,
                                                           @PathVariable UUID idBook) {
        Chatroom chatroom = chatroomCRUD.registerNewChatroom(idUser, idBook);


        return ResponseEntity.ok(ChatroomResponse.createFromChatroom(chatroom));
    }

    @GetMapping("/{chatroomId}")
    public ResponseEntity<ChatroomResponse> getChatroomById(@PathVariable UUID chatroomId) {
        Chatroom chatroom = chatroomCRUD.getById(chatroomId);
        return ResponseEntity.ok(ChatroomResponse.createFromChatroom(chatroom));
    }

    @GetMapping("/idUser/{idUser}")
    public ResponseEntity<ChatroomResponse> getChatroomByIdUser(@PathVariable UUID idUser) {
        Chatroom chatroom = chatroomCRUD.getByIdUser(idUser);
        return ResponseEntity.ok(ChatroomResponse.createFromChatroom(chatroom));
    }

    @GetMapping("/idBook/{idBook}")
    public ResponseEntity<ChatroomResponse> getChatroomByIdBook(@PathVariable UUID idBook) {
        Chatroom chatroom = chatroomCRUD.getByIdBook(idBook);
        return ResponseEntity.ok(ChatroomResponse.createFromChatroom(chatroom));
    }

    @RequestMapping("/all")
    public ResponseEntity<List<ChatroomResponse>> getAllChatrooms() {
        List<Chatroom> chatrooms = chatroomCRUD.getAllChatroom();
        return ResponseEntity.ok(chatrooms.stream()
                .map(ChatroomResponse::createFromChatroom).toList());
    }
}
