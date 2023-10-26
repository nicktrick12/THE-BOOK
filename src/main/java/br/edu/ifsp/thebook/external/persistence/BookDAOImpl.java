package br.edu.ifsp.thebook.external.persistence;

import br.edu.ifsp.thebook.domain.book.Book;
import br.edu.ifsp.thebook.domain.user.User;
import br.edu.ifsp.thebook.usecases.book.gateway.BookDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public class BookDAOImpl implements BookDAO {

    private JdbcTemplate jdbcTemplate;

    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Value("${queries.sql.book-dao.insert.book}")
    private String insertUserQuery;

    @Override
    public Book addNewBook(Book book) {
        UUID bookId = UUID.randomUUID();

        jdbcTemplate.update(insertUserQuery, bookId, book.getPages(), book.getTitle(),
                book.getGender(), book.getAuthor(), book.getClassification(), book.getSummary(),
                Timestamp.valueOf(LocalDateTime.now()), book.getIdUserAdd(), book.getBookState().name(), book.getAverage());

        return book.createWithId(bookId);
    }
}
