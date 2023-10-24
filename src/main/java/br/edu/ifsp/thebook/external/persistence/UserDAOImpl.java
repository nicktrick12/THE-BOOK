package br.edu.ifsp.thebook.external.persistence;

import br.edu.ifsp.thebook.domain.user.Role;
import br.edu.ifsp.thebook.domain.user.Situation;
import br.edu.ifsp.thebook.domain.user.User;
import br.edu.ifsp.thebook.usecases.user.gateway.UserDAO;
import br.edu.ifsp.thebook.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Value("${queries.sql.user-dao.insert.user}")
    private String insertUserQuery;
    @Value("${queries.sql.user-dao.select.user-by-id}")
    private String selectUserByIdQuery;
    @Value("${queries.sql.user-dao.select.user-by-email}")
    private String selectUserByEmailQuery;
    @Value("${queries.sql.user-dao.select.user-by-username}")
    private String selectUserByUsernameQuery;
    @Value("${queries.sql.user-dao.exists.user-by-id}")
    private String existsUserIdQuery;

    @Override
    public User addNewUser(User user) {

        UUID userId = UUID.randomUUID();
        System.out.println(user.getSituation().name());
        System.out.println(user.getRole().name());

        jdbcTemplate.update(insertUserQuery, userId, user.getName(), user.getUsername(),
                user.getEmail(), user.getPassword(), user.getBirth(), user.getCPF(),
                user.getEntryDate(), user.getSituation().name(), user.getRole().name());

        return user.createWithId(userId);
    }

    @Override
    public Optional<User> findById(UUID id) {
        try {
            User user = jdbcTemplate.queryForObject(selectUserByIdQuery,
                    this::mapperUserFromRs, id);

            if(Objects.isNull(user)) {
                throw new ResourceNotFoundException("Could not find user with id: " + id);
            }

            return Optional.of(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            User user = jdbcTemplate.queryForObject(selectUserByEmailQuery,
                    this::mapperUserFromRs, email);

            if(Objects.isNull(user)) {
                throw new ResourceNotFoundException("Could not find user with email: " + email);
            }

            return Optional.of(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try {
            User user = jdbcTemplate.queryForObject(selectUserByUsernameQuery,
                    this::mapperUserFromRs, username);

            if(Objects.isNull(user)) {
                throw new ResourceNotFoundException("Could not find user with username: " + username);
            }

            return Optional.of(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public Boolean userExists(UUID userId) {
        Boolean exists = jdbcTemplate.queryForObject(existsUserIdQuery, Boolean.class, userId);
        return Objects.nonNull(exists) && exists;
    }

    private User mapperUserFromRs(ResultSet rs, int rowNum) throws SQLException {
        UUID id = (UUID) rs.getObject("id");
        String name = rs.getString("nome");
        String username = rs.getString("username");
        String email = rs.getString("email");
        String password = rs.getString("senha");
        Timestamp birth = rs.getTimestamp("data_nasc");
        String CPF = rs.getString("CPF");
        Timestamp entryDate = rs.getTimestamp("data_entr");
        Situation situation = Situation.valueOf(rs.getString("situacao"));
        Role role = Role.valueOf(rs.getString("papel"));

        return User.createFull(id, name, username, email, password,
                birth, CPF, entryDate, situation, role);
    }

}
