package br.edu.ifsp.thebook.web.model.reading.request;

import br.edu.ifsp.thebook.domain.reading.ReadingState;

public class ReadingUpdateRequest {
    private ReadingState readingState;

    public ReadingUpdateRequest(ReadingState readingState) {
        this.readingState = readingState;
    }

    public ReadingUpdateRequest() {
    }

    public ReadingState getReadingState() {
        return readingState;
    }

    public void setReadingState(ReadingState readingState) {
        this.readingState = readingState;
    }
}
