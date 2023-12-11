package br.edu.ifsp.thebook.usecases.book.gateway;

import br.edu.ifsp.thebook.domain.book.Book;

import java.util.*;

public interface BookDAO {
    Book addNewBook(Book book);
    List<Book> findAll();
    Optional <Book> findById (UUID id);
}
