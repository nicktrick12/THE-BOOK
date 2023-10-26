package br.edu.ifsp.thebook.usecases.book.gateway;

import br.edu.ifsp.thebook.domain.book.Book;

public interface BookDAO {
    Book addNewBook(Book book);
}
