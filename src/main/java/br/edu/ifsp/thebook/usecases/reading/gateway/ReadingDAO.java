package br.edu.ifsp.thebook.usecases.reading.gateway;

import br.edu.ifsp.thebook.domain.reading.Reading;

import java.util.List;
import java.util.UUID;

public interface ReadingDAO {
    Reading addNewReading(Reading reading);
    List<Reading> findAll(UUID userId);
<<<<<<< HEAD

=======
>>>>>>> f4090362c89370636202dac0a4261524a224e09c
    Reading updateFavorite(Reading reading);
    Reading updateState(Reading reading);

    Reading findByUserIdAndBookId(UUID idUser, UUID idBook);
}
