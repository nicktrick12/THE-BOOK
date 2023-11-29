package br.edu.ifsp.thebook.usecases.user.gateway;

import br.edu.ifsp.thebook.domain.user.User;

import java.util.*;

public interface UserDAO {
    User addNewUser(User user);
    List<User> findAll();
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    User update(User user);
    Boolean userExists(UUID userId);
    Optional<User> findLogin(String username, String password);
}
