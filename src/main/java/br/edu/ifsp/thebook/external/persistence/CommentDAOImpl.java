package br.edu.ifsp.thebook.external.persistence;

import br.edu.ifsp.thebook.domain.comment.Comment;
import br.edu.ifsp.thebook.usecases.comment.gateway.CommentDAO;
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
public class CommentDAOImpl implements CommentDAO {

    private JdbcTemplate jdbcTemplate;

    public CommentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Value("${queries.sql.comment-dao.insert.comment}")
    private String insertCommentQuery;
    @Value("${queries.sql.comment-dao.select.all}")
    private String selectAllCommentQuery;
    @Value("${queries.sql.comment-dao.select.comment-by-id}")
    private String selectCommentByIdQuery;
    @Value("${queries.sql.comment-dao.select.comment-by-id-user}")
    private String selectCommentByIdUserQuery;
    @Value("${queries.sql.comment-dao.select.comments-by-id-chatroom}")
    private String selectAllCommentsByChatroomIdQuery;

    @Override
    public Comment addNewComment(Comment comment) {
        UUID commentId = UUID.randomUUID();

        jdbcTemplate.update(insertCommentQuery, commentId, comment.getIdUser(), comment.getIdChatroom(),
                comment.getText());

        return comment.createWithId(commentId);
    }

    @Override
    public List<Comment> findAll() {
        return jdbcTemplate.query(selectAllCommentQuery, this::mapperCommentFromRs);
    }

    @Override
    public Optional<Comment> findById(UUID id) {
        try {
            Comment comment = jdbcTemplate.queryForObject(selectCommentByIdUserQuery,
                    this::mapperCommentFromRs, id);

            if(Objects.isNull(comment)) {
                throw new ResourceNotFoundException("Could not find comment with id: " + id);
            }

            return Optional.of(comment);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Comment> findByIdUser(UUID idUser) {
        try {
            Comment comment = jdbcTemplate.queryForObject(selectCommentByIdQuery,
                    this::mapperCommentFromRs, idUser);

            if(Objects.isNull(comment)) {
                throw new ResourceNotFoundException("Could not find comment with idUser: " + idUser);
            }

            return Optional.of(comment);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Comment> findAllByIdChatroom(UUID idChatroom) {
        return jdbcTemplate.query(selectAllCommentsByChatroomIdQuery, this::mapperCommentFromRs, idChatroom);
    }

    @Override
    public Comment delete(Comment comment) {
        return null;
    }

    @Override
    public Boolean commentExists(UUID commentId) {
        return null;
    }

    private Comment mapperCommentFromRs(ResultSet rs, int rowNum) throws SQLException {
        UUID id = (UUID) rs.getObject("id");
        UUID idUser = (UUID) rs.getObject("id_user");
        UUID idChatroom = (UUID) rs.getObject("id_chatroom");
        String text = rs.getString("text");

        return Comment.createFull(id, idUser, idChatroom, text);
    }
}
