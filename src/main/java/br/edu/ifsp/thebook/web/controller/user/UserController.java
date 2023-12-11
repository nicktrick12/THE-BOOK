package br.edu.ifsp.thebook.web.controller.user;

import br.edu.ifsp.thebook.domain.user.User;
import br.edu.ifsp.thebook.usecases.user.UserCRUD;
import br.edu.ifsp.thebook.web.model.user.request.LoginRequest;
import br.edu.ifsp.thebook.web.model.user.request.UserRequest;
import br.edu.ifsp.thebook.web.model.user.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("api/v1/users/email/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        User user = userCRUD.getByEmail(email);
        return ResponseEntity.ok(UserResponse.createFromUser(user));
    }

    @GetMapping("api/v1/users/username/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
        User user = userCRUD.getByUsername(username);
        return ResponseEntity.ok(UserResponse.createFromUser(user));
    }

    @GetMapping("api/v1/users/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> users = userCRUD.getAll();
        return ResponseEntity.ok(users.stream()
                .map(UserResponse::createFromUser).toList());
    }

    @PostMapping("api/v1/users/login")
    public ResponseEntity<UserResponse> getLogin(@RequestBody LoginRequest request) {
        User user = userCRUD.getLogin(request);
        return ResponseEntity.ok(UserResponse.createFromUser(user));
    }


}
