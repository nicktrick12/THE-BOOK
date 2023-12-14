package br.edu.ifsp.thebook.usecases.reading;

import br.edu.ifsp.thebook.domain.reading.Reading;
import br.edu.ifsp.thebook.web.model.reading.request.ReadingUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface ReadingCRUD {
    Reading registerNewReading(UUID idUser, UUID idBook);
    List<Reading> getAllReading(UUID userId);
    List<Reading> getAllFavorites(UUID userId);
    Reading findReading(UUID idUser, UUID idBook);
    Reading updateState(UUID idUser, UUID idBook, ReadingUpdateRequest request);
    Reading updateFavorite(UUID idUser, UUID idBook);

}
