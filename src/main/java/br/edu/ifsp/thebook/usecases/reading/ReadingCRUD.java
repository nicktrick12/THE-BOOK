package br.edu.ifsp.thebook.usecases.reading;

import br.edu.ifsp.thebook.domain.reading.Reading;

import java.util.List;
import java.util.UUID;

public interface ReadingCRUD {
    Reading registerNewReading(UUID idUser, UUID idBook);

    List<Reading> getAllReading();
}
