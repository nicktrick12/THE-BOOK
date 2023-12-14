package br.edu.ifsp.thebook.web.controller.reading;

import br.edu.ifsp.thebook.domain.book.Book;
import br.edu.ifsp.thebook.domain.comment.Comment;
import br.edu.ifsp.thebook.domain.reading.Reading;
import br.edu.ifsp.thebook.usecases.book.BookCRUD;
import br.edu.ifsp.thebook.usecases.reading.ReadingCRUD;
import br.edu.ifsp.thebook.web.model.book.request.BookRequest;
import br.edu.ifsp.thebook.web.model.book.response.BookResponse;
import br.edu.ifsp.thebook.web.model.comment.response.CommentResponse;
import br.edu.ifsp.thebook.web.model.reading.request.ReadingUpdateRequest;
import br.edu.ifsp.thebook.web.model.reading.response.ReadingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/readings")
@RestController
public class ReadingController {

    private final ReadingCRUD readingCRUD;

    public ReadingController(ReadingCRUD readingCRUD) {

        this.readingCRUD = readingCRUD;
    }

    @PostMapping("/users/{idUser}/books/{idBook}/add")
    public ResponseEntity<ReadingResponse> addReading(@PathVariable UUID idUser,
                                                   @PathVariable UUID idBook) {
        Reading reading = readingCRUD.registerNewReading(idUser, idBook);
        return ResponseEntity.ok(ReadingResponse.createFromReading(reading));
    }

    @GetMapping("/users/{idUser}/books/{idBook}")
    public ResponseEntity<ReadingResponse> findReading(@PathVariable UUID idUser,
                                                      @PathVariable UUID idBook) {
        Reading reading = readingCRUD.findReading(idUser, idBook);
        return ResponseEntity.ok(ReadingResponse.createFromReading(reading));
    }

    @PutMapping("/users/{idUser}/books/{idBook}/state")
    public ResponseEntity<ReadingResponse> updateState(@PathVariable UUID idUser,
                                                      @PathVariable UUID idBook,
                                                      @RequestBody ReadingUpdateRequest request) {
        Reading reading = readingCRUD.updateState(idUser, idBook, request);
        return ResponseEntity.ok(ReadingResponse.createFromReading(reading));
    }

    @PutMapping("/users/{idUser}/books/{idBook}/favorite")
    public ResponseEntity<ReadingResponse> updateFavorite(@PathVariable UUID idUser,
                                                         @PathVariable UUID idBook) {
        Reading reading = readingCRUD.updateFavorite(idUser, idBook);
        return ResponseEntity.ok(ReadingResponse.createFromReading(reading));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<ReadingResponse>> findReadings(@PathVariable UUID userId) {
        List <Reading> readings = readingCRUD.getAllReading(userId);

        return ResponseEntity.ok(
                readings.stream()
                        .map(ReadingResponse::createFromReading)
                        .collect(java.util.stream.Collectors.toList())
        );
    }

    @GetMapping("/favorites/users/{userId}")
    public ResponseEntity<List<ReadingResponse>> findFavorites(@PathVariable UUID userId) {
        List <Reading> readings = readingCRUD.getAllFavorites(userId);

        return ResponseEntity.ok(
                readings.stream()
                        .map(ReadingResponse::createFromReading)
                        .collect(java.util.stream.Collectors.toList())
        );
    }


}
