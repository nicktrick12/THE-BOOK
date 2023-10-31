package br.edu.ifsp.thebook.web.controller.reading;

import br.edu.ifsp.thebook.domain.book.Book;
import br.edu.ifsp.thebook.domain.reading.Reading;
import br.edu.ifsp.thebook.usecases.book.BookCRUD;
import br.edu.ifsp.thebook.usecases.reading.ReadingCRUD;
import br.edu.ifsp.thebook.web.model.book.request.BookRequest;
import br.edu.ifsp.thebook.web.model.book.response.BookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/readings")
@RestController
public class ReadingController {

    private final ReadingCRUD readingCRUD;

    public ReadingController(ReadingCRUD readingCRUD) {
        this.readingCRUD = readingCRUD;
    }

    @PostMapping("/add")
    public ResponseEntity<BookResponse> addReading(@PathVariable UUID idUser,
                                                   @PathVariable UUID idBook) {
        Reading reading = readingCRUD.registerNewReading(idUser, idBook);
        return ResponseEntity.ok(ReadingResponse.createFromReading(reading));
    }

}
