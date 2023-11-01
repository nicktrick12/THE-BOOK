package br.edu.ifsp.thebook.web.model.reading.response;

import br.edu.ifsp.thebook.domain.reading.Reading;
import br.edu.ifsp.thebook.domain.reading.ReadingState;

import java.sql.Timestamp;
import java.util.UUID;

public class ReadingResponse {
    private UUID id;
    private UUID idUser;
    private UUID idBook;
    private Timestamp date_start;
    private ReadingState readingState;
    private boolean isFavorite;
    private int rating;

    public ReadingResponse() {
    }

    public ReadingResponse(UUID id, UUID idUser, UUID idBook,
                           Timestamp date_start, ReadingState readingState,
                           boolean isFavorite, int rating) {
        this.id = id;
        this.idUser = idUser;
        this.idBook = idBook;
        this.date_start = date_start;
        this.readingState = readingState;
        this.isFavorite = isFavorite;
        this.rating = rating;
    }

    public static ReadingResponse createFromReading(Reading reading){
        return new ReadingResponse(
                reading.getId(),
                reading.getIdUser(),
                reading.getIdBook(),
                reading.getDateStart(),
                reading.getReadingState(),
                reading.isFavorite(),
                reading.getRating()
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public UUID getIdBook() {
        return idBook;
    }

    public void setIdBook(UUID idBook) {
        this.idBook = idBook;
    }

    public Timestamp getDate_start() {
        return date_start;
    }

    public void setDate_start(Timestamp date_start) {
        this.date_start = date_start;
    }

    public ReadingState getReadingState() {
        return readingState;
    }

    public void setReadingState(ReadingState readingState) {
        this.readingState = readingState;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
