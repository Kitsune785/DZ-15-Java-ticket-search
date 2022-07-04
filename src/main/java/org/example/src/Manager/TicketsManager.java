package org.example.src.Manager;

import org.example.src.domain.Tickets;
import org.example.src.repository.TicketsRepository;

import java.util.Arrays;

public class TicketsManager {

    private TicketsRepository repo;

    public TicketsManager(TicketsRepository repo) {
        this.repo = repo;
    }

    public void addNewTickets(Tickets item) {
        repo.addTickets(item);
    }

    public Tickets[] findAll(String departureAirport, String arrivalАirport) {
        Tickets[] result = new Tickets[0];
        for (Tickets ticket : repo.findAll()) {
            if (ticket.getDepartureAirport().equalsIgnoreCase(departureAirport) && ticket.getArrivalАirport().equalsIgnoreCase(arrivalАirport)) {
                Tickets[] tmp = new Tickets[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}