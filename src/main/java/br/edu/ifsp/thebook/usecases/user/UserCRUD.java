package br.edu.ifsp.thebook.usecases.user;

import br.edu.ifsp.thebook.domain.user.User;
import br.edu.ifsp.thebook.web.model.user.request.LoginRequest;
import br.edu.ifsp.thebook.web.model.user.request.UserRequest;

import java.util.*;

public interface UserCRUD {
    User registerNewUser(UserRequest request);
    List<User> getAll();
    User getLogin(LoginRequest request);
    User getById(UUID id);

    User getByEmail(String email);

    User getByUsername(String username);

    User update(UserRequest request, UUID id);

}
