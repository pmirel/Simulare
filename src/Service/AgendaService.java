package Service;

import Domain.Agenda;
import Repository.InMemoryRepository;

import java.util.List;

public class AgendaService {

    private InMemoryRepository agendaRepository;

    public AgendaService(InMemoryRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    /**
     * insert a new agenda in a day
     * @param id
     * @param name
     * @param day
     * @param duration
     * @param startHour
     */
    public void insert(String id, String name, String day, String duration, String startHour) {
        Agenda agenda = new Agenda(id, name,day,duration,startHour);
        agendaRepository.insert(agenda);
    }

    /**
     * @return an List with all invoices
     */
    public List<Agenda> getAll() {
        return agendaRepository.getAll();
    }
   // public List<Agenda> getAmount() { return agendaRepository.getAmount();}


}
