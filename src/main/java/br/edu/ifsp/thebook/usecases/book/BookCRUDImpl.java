package br.edu.ifsp.thebook.usecases.book;

import br.edu.ifsp.thebook.domain.book.Book;
import br.edu.ifsp.thebook.domain.user.Situation;
import br.edu.ifsp.thebook.domain.user.User;
import br.edu.ifsp.thebook.usecases.book.gateway.BookDAO;
import br.edu.ifsp.thebook.web.model.book.request.BookRequest;
import org.springframework.stereotype.Service;

@Service
public class BookCRUDImpl implements BookCRUD {

    private final BookDAO bookDAO;

    public BookCRUDImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Book registerNewBook(BookRequest request) {
        Book book = request.toBook();
        user.setSituation(Situation.LIVRE);
        return userDAO.addNewUser(user);
    }
}
