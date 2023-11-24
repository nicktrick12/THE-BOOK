package br.edu.ifsp.thebook.external.persistence;

import br.edu.ifsp.thebook.domain.chatroom.Chatroom;
import br.edu.ifsp.thebook.usecases.chatroom.gateway.ChatroomDAO;
import br.edu.ifsp.thebook.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ChatroomDAOImpl implements ChatroomDAO {
    private JdbcTemplate jdbcTemplate;
    public ChatroomDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Value("${queries.sql.chatroom-dao.insert.chatroom}")
    private String insertChatroomQuery;
    @Value("${queries.sql.chatroom-dao.select.all}")
    private String selectAllChatroomsQuery;
    @Value("${queries.sql.chatroom-dao.select.chatroom-by-id}")
    private String selectChatroomByIdQuery;
    @Value("${queries.sql.chatroom-dao.select.chatroom-by-id-user}")
    private String selectChatroomByIdUserQuery;
    @Value("${queries.sql.chatroom-dao.select.chatroom-by-id-book}")
    private String selectChatroomByIdBookQuery;
    @Value("${queries.sql.chatroom-dao.exists.chatroom-by-id}")
    private String existsChatroomIdQuery;


    @Override
    public Chatroom addNewChatroom(Chatroom chatroom) {
        UUID chatroomId = UUID.randomUUID();

        jdbcTemplate.update(insertChatroomQuery, chatroomId, chatroom.getIdUser(), chatroom.getIdBook());

        return chatroom.createWithId(chatroomId);
    }

    @Override
    public List<Chatroom> findAll() {
        return jdbcTemplate.query(selectAllChatroomsQuery, this::mapperChatroomFromRs);
    }

    @Override
    public Optional<Chatroom> findById(UUID id) {
        try {
            Chatroom chatroom = jdbcTemplate.queryForObject(selectChatroomByIdQuery,
                    this::mapperChatroomFromRs, id);

            if(Objects.isNull(chatroom)) {
                throw new ResourceNotFoundException("Could not find chatroom with id: " + id);
            }

            return Optional.of(chatroom);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Chatroom> findByIdUser(UUID idUser) {
        try {
            Chatroom chatroom = jdbcTemplate.queryForObject(selectChatroomByIdUserQuery,
                    this::mapperChatroomFromRs, idUser);

            if(Objects.isNull(chatroom)) {
                throw new ResourceNotFoundException("Could not find chatroom with idUser: " + idUser);
            }

            return Optional.of(chatroom);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Chatroom> findByIdBook(UUID idBook) {
        try {
            Chatroom chatroom = jdbcTemplate.queryForObject(selectChatroomByIdBookQuery,
                    this::mapperChatroomFromRs, idBook);

            if(Objects.isNull(chatroom)) {
                throw new ResourceNotFoundException("Could not find chatroom with idBook: " + idBook);
            }

            return Optional.of(chatroom);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
    public Boolean ChatroomExists(UUID chatroomId) {
        Boolean exists = jdbcTemplate.queryForObject(existsChatroomIdQuery, Boolean.class, chatroomId);
        return Objects.nonNull(exists) && exists;
    }

    private Chatroom mapperChatroomFromRs(ResultSet rs, int rowNum) throws SQLException {
        UUID id = (UUID) rs.getObject("id");
        UUID idUser = (UUID) rs.getObject("id_user");
        UUID idBook = (UUID) rs.getObject("id_book");

        return Chatroom.createFull(id, idUser, idBook);
    }
}
