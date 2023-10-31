package br.edu.ifsp.thebook.usecases.reading;

import br.edu.ifsp.thebook.domain.reading.Reading;
import br.edu.ifsp.thebook.usecases.reading.gateway.ReadingDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReadingCRUDlmpl implements ReadingCRUD{

    private final ReadingDAO readingDAO;

    public ReadingCRUDlmpl(ReadingDAO readingDAO) {
        this.readingDAO = readingDAO;
    }

    @Override
    public Reading registerNewReading(UUID idUser, UUID idBook) {
        Reading reading = new Reading(idUser, idBook);
        return readingDAO.addNewReading(reading);
    }

    @Override
    public List<Reading> getAllReading() {
        return readingDAO.findAll();
    }
}
