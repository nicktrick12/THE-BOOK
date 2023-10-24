package br.edu.ifsp.thebook.web.controller.user;

import br.edu.ifsp.thebook.domain.user.User;
import br.edu.ifsp.thebook.usecases.user.UserCRUD;
import br.edu.ifsp.thebook.web.model.user.request.UserRequest;
import br.edu.ifsp.thebook.web.model.user.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    private final UserCRUD userCRUD;

    public UserController(UserCRUD userCRUD) {
        this.userCRUD = userCRUD;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = userCRUD.registerNewUser(userRequest);

        return ResponseEntity.ok(UserResponse.createFromUser(user));
    }

    @GetMapping("api/v1/users/id/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID userId) {
        User user = userCRUD.getById(userId);
        return ResponseEntity.ok(UserResponse.createFromUser(user));
    }

}
