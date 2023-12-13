package br.edu.ifsp.thebook.web.controller.book;

import br.edu.ifsp.thebook.usecases.book.BookCRUD;
import br.edu.ifsp.thebook.web.model.book.request.BookRequest;
import br.edu.ifsp.thebook.web.model.book.response.BookResponse;
import br.edu.ifsp.thebook.domain.book.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/books")
@RestController
public class BookController {

    private final BookCRUD bookCRUD;

    public BookController(BookCRUD bookCRUD) {
        this.bookCRUD = bookCRUD;
    }

    @PostMapping("/add")
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest request) {
        Book book = bookCRUD.registerNewBook(request);
        return ResponseEntity.ok(BookResponse.createFromBook(book));
    }

    @GetMapping("{bookId}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable UUID bookId){
        Book book = bookCRUD.getById(bookId);
        return ResponseEntity.ok(BookResponse.createFromBook(book));
    }

}
