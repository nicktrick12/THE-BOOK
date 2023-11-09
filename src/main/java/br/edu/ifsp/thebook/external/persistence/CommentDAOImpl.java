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
    @Value("${queries.sql.comment-dao.select.comment-by-idUser}")
    private String selectCommentByIdUserQuery;
    @Value("${queries.sql.comment-dao.select.comment-by-idBook}")
    private String selectCommentByIdBookQuery;
    @Value("${queries.sql.comment-dao.exists.comment-by-id}")
    private String existsCommentIdQuery;

    @Override
    public Comment addNewComment(Comment comment) {
        UUID commentId = UUID.randomUUID();

        jdbcTemplate.update(insertCommentQuery, commentId, comment.getIdUser(), comment.getIdBook(),
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
    public Optional<Comment> findByIdBook(UUID idBook) {
        try {
            Comment comment = jdbcTemplate.queryForObject(selectCommentByIdBookQuery,
                    this::mapperCommentFromRs, idBook);

            if(Objects.isNull(comment)) {
                throw new ResourceNotFoundException("Could not find comment with idBook: " + idBook);
            }

            return Optional.of(comment);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Comment delete(Comment comment) {
        return null;
    }

    @Override
    public Boolean commentExists(UUID commentId) {
        Boolean exists = jdbcTemplate.queryForObject(existsCommentIdQuery, Boolean.class, commentId);
        return Objects.nonNull(exists) && exists;
    }
    private Comment mapperCommentFromRs(ResultSet rs, int rowNum) throws SQLException {
        UUID id = (UUID) rs.getObject("id");
        UUID idUser = (UUID) rs.getObject("idUser");
        UUID idBook = (UUID) rs.getObject("idBook");
        String text = rs.getString("text");

        return Comment.createFull(id, idUser, idBook, text);
    }
}
