package br.edu.ifsp.thebook.web.controller.chatroom;

import br.edu.ifsp.thebook.domain.chatroom.Chatroom;
import br.edu.ifsp.thebook.usecases.chatroom.ChatroomCRUD;
import br.edu.ifsp.thebook.web.model.chatroom.request.ChatroomRequest;
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
    @PostMapping("/add")
    public ResponseEntity<ChatroomResponse> createChatroom(@RequestBody ChatroomRequest chatroomRequest) {
        Chatroom chatroom = chatroomCRUD.registerNewChatroom(chatroomRequest);

        return ResponseEntity.ok(ChatroomResponse.createFromChatroom(chatroom));
    }

    @GetMapping("/id/{chatroomId}")
    public ResponseEntity<ChatroomResponse> getChatroomById(@PathVariable UUID chatroomid) {
        Chatroom chatroom = chatroomCRUD.getById(chatroomid);
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

    @GetMapping("/title/{title}")
    public ResponseEntity<ChatroomResponse> getChatroomByTitle(@PathVariable String title) {
        Chatroom chatroom = chatroomCRUD.getByTitle(title);
        return ResponseEntity.ok(ChatroomResponse.createFromChatroom(chatroom));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChatroomResponse>> getAllChatrooms() {
        List<Chatroom> chatrooms = chatroomCRUD.getAllChatroom();
        return ResponseEntity.ok(chatrooms.stream()
                .map(ChatroomResponse::createFromChatroom).toList());
    }
}
