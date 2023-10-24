package br.edu.ifsp.thebook.web.controller.book;

import br.edu.ifsp.thebook.web.model.book.response.BookResponse;
import br.edu.ifsp.thebook.domain.book.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/tasks/")
@RestController
public class BookController {

//    private final BookCRUD bookCRUD;
//
//    public BookController(BookCRUD bookCRUD) {
//        this.bookCRUD = bookCRUD;
//    }
//
//    @GetMapping("/books")
//    public ResponseEntity<BookResponse> getCommitByTaskId(
//            @PathVariable UUID bookId) {
//        Book book = bookCRUD.getBookById(bookId);
//
//        return ResponseEntity.ok(BookResponse.convertFromBook(book));
//    }

}
