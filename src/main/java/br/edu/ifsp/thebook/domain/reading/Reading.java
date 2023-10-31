package br.edu.ifsp.thebook.domain.reading;

import java.sql.Timestamp;
import java.util.UUID;

public class Reading {
    private UUID id;
    private UUID idUser;
    private UUID idBook;
    private Timestamp dateStart;
    private ReadingState readingState;
    private boolean isFavorite;
    private int rating;
    public Reading(UUID id, UUID idUser, UUID idBook, Timestamp dateStart,
                   ReadingState readingState, boolean isFavorite,
                   int rating)
    {
        this.id = id;
        this.idUser = idUser;
        this.idBook = idBook;
        this.dateStart = dateStart;
        this.readingState = readingState;
        this.isFavorite = isFavorite;
        this.rating = rating;
    }

    public Reading(UUID idUser, UUID idBook, Timestamp dateStart,
                   ReadingState readingState, boolean isFavorite,
                   int rating)
    {
        this.idUser = idUser;
        this.idBook = idBook;
        this.dateStart = dateStart;
        this.readingState = readingState;
        this.isFavorite = isFavorite;
        this.rating = rating;
    }

    public Reading(UUID idUser, UUID idBook) {
        this.idUser = idUser;
        this.idBook = idBook;
    }

    public Reading createWithId(UUID id) {
        return new Reading(id, idUser, idBook, dateStart,
                readingState, isFavorite, rating);

    }

    public Reading createWithUserIdAndBookId(UUID idUser, UUID idBook) {
        return new Reading(idUser, idBook);
    }

    public static Reading createFull(UUID id, UUID idUser, UUID idBook, Timestamp dateStart,
                                     ReadingState readingState, boolean isFavorite,
                                     int rating){
        return new Reading(id, idUser, idBook, dateStart,
                readingState, isFavorite, rating);
    }
    public static Reading createFromBook(UUID idUser, UUID idBook, Timestamp dateStart,
                                         ReadingState readingState, boolean isFavorite,
                                         int rating){
        return new Reading(idUser, idBook, dateStart,
                readingState, isFavorite, rating
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

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
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
