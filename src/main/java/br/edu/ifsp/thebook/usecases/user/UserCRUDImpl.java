package br.edu.ifsp.thebook.usecases.user;

import br.edu.ifsp.thebook.domain.user.Situation;
import br.edu.ifsp.thebook.domain.user.User;
import br.edu.ifsp.thebook.usecases.user.gateway.UserDAO;
import br.edu.ifsp.thebook.web.model.user.request.LoginRequest;
import br.edu.ifsp.thebook.web.model.user.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserCRUDImpl implements UserCRUD {
    private final UserDAO userDAO;
    public UserCRUDImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public User registerNewUser(UserRequest request) {
        User user = request.toUser();
        return userDAO.addNewUser(user);
    }

    @Override
    public List<User> getAll() {
        List<User> users = userDAO.findAll();
        return users;
    }

    @Override
    public User getById(UUID id) {
        User user = userDAO.findById(id).get();
        return user;
    }

    @Override
    public User getByEmail(String email) {
        User user = userDAO.findByEmail(email).get();
        return user;
    }

    @Override
    public User getByUsername(String username) {
        User user = userDAO.findByUsername(username).get();
        return user;
    }

    @Override
    public User update(UserRequest request, UUID userId) {
        return null;
    }

    @Override
    public User getLogin(LoginRequest request) {
        User user = userDAO.findLogin(request.getUsername(), request.getPassword()).get();
        return user;
    }
}
