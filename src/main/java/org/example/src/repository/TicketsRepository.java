package org.example.src.repository;

import org.example.src.domain.Tickets;

public class TicketsRepository {

    private Tickets[] ticket = new Tickets[0];

    public void addTickets(Tickets item) {
        int length = ticket.length + 1;
        Tickets[] tmp = new Tickets[length];
        System.arraycopy(ticket, 0, tmp, 0, ticket.length);
        int finalIndex = tmp.length - 1;
        tmp[finalIndex] = item;
        ticket = tmp;
    }

    public Tickets[] getItems() {
        return ticket;
    }

    public void removeFilmById(int id) {
        Tickets[] tmp = new Tickets[ticket.length - 1];
        int copyToIndex = 0;
        for (Tickets item : ticket) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        ticket = tmp;
    }

    public Tickets findById(int id) {
        for (Tickets item : ticket) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Tickets[] findAll() {
        return ticket;
    }
}