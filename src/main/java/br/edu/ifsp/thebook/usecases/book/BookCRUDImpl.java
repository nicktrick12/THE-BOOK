package br.edu.ifsp.thebook.usecases.book;

import br.edu.ifsp.thebook.domain.book.Book;
import br.edu.ifsp.thebook.usecases.book.gateway.BookDAO;
import br.edu.ifsp.thebook.web.model.book.request.BookRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class BookCRUDImpl implements BookCRUD {

    private final BookDAO bookDAO;

    public BookCRUDImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Book registerNewBook(BookRequest request) {
        Book book = request.toBook();
        Book bookPersistence = null;
        boolean isDuplicate = false;

        for (Book bookDB : getAllBooks()) {
            if (isSameBook(book, bookDB)) {
                isDuplicate = true;
                bookPersistence = bookDB;
                break;
            }
        }

        if (isDuplicate) {
            return bookPersistence;
        } else {
            return bookDAO.addNewBook(book);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }

    private boolean isSameBook(Book book1, Book book2) {
        return book1.getTitle().equals(book2.getTitle()) &&
                book1.getAuthor().equals(book2.getAuthor()) &&
                book1.getPages() == (book2.getPages()) &&
                book1.getGender().equals(book2.getGender()) &&
                book1.getClassification() == (book2.getClassification()) &&
                book1.getSummary().equals(book2.getSummary()) &&
                book1.getBookState().equals(book2.getBookState());
    }

    @Override
    public Book getById(UUID id){
        Book book = bookDAO.findById(id).get();
        return book;
    }

}
