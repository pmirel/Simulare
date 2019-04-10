package Test;

import Domain.AgendaValidator;
import Repository.InMemoryRepository;
import Service.AgendaService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaServiceTest {
    private AgendaValidator validator = new AgendaValidator();
    private InMemoryRepository repository = new InMemoryRepository(validator);
    private AgendaService service = new AgendaService(repository);

    @Test
    void testsIfInputIsCorrect() {
        service.insert("1","scoala","11.11.2018","60","12.00");
        assertEquals(32, service.getAll().get(0).getDuration());


        try {
            service.insert("1","scoala","11.11.2018","60","12.00");
        } catch (RuntimeException rex) { assertTrue(true); }
    }
}
