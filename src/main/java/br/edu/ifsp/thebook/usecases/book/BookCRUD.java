package br.edu.ifsp.thebook.usecases.book;

import br.edu.ifsp.thebook.domain.book.Book;
import br.edu.ifsp.thebook.web.model.book.request.BookRequest;

import java.util.List;

public interface BookCRUD {
    Book registerNewBook(BookRequest request);

    List<Book> getAllBooks();
}
