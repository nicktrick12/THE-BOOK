package br.edu.ifsp.thebook.usecases.reading.gateway;

import br.edu.ifsp.thebook.domain.reading.Reading;

import java.util.List;

public interface ReadingDAO {
    Reading addNewReading(Reading reading);
    List<Reading> findAll();

    Reading updateFavorite (Reading reading);

}
