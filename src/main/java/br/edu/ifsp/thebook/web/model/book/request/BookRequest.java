package br.edu.ifsp.thebook.web.model.book.request;

import br.edu.ifsp.thebook.domain.book.Book;
import br.edu.ifsp.thebook.domain.book.BookState;
import br.edu.ifsp.thebook.domain.user.User;

import java.sql.Timestamp;
import java.util.UUID;

public class BookRequest {
    private int pages;
    private String title;
    private String gender;
    private String author;
    private int classification;
    private String summary;
    private Timestamp dataAdd;
    private UUID idUserAdd;
    private BookState bookState;
    private int average;

    public BookRequest(int pages, String title, String gender, String author,
                       int classification, String summary, Timestamp dataAdd,
                       UUID idUserAdd, BookState bookState, int average) {
        this.pages = pages;
        this.title = title;
        this.gender = gender;
        this.author = author;
        this.classification = classification;
        this.summary = summary;
        this.dataAdd = dataAdd;
        this.idUserAdd = idUserAdd;
        this.bookState = bookState;
        this.average = average;
    }

    public Book toBook() {
        return Book.createFromBook(pages, title, gender, author, classification, summary, dataAdd, idUserAdd, bookState, average);
    }

    public BookRequest() {
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Timestamp getDataAdd() {
        return dataAdd;
    }

    public void setDataAdd(Timestamp dataAdd) {
        this.dataAdd = dataAdd;
    }

    public UUID getIdUserAdd() {
        return idUserAdd;
    }

    public void setIdUserAdd(UUID idUserAdd) {
        this.idUserAdd = idUserAdd;
    }

    public BookState getBookState() {
        return bookState;
    }

    public void setBookState(BookState bookState) {
        this.bookState = bookState;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }
}
