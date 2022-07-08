package org.example.src.repository;

import org.example.src.domain.Tickets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketsRepositoryTest {

    TicketsRepository repo = new TicketsRepository();

    Tickets item1 = new Tickets(1, 100, "AEP", "BRU", 10);
    Tickets item2 = new Tickets(2, 200, "ARN", "BTS", 20);
    Tickets item3 = new Tickets(3, 300, "AUH", "BUD", 30);
    Tickets item4 = new Tickets(4, 400, "AZI", "BWI", 40);
    Tickets item5 = new Tickets(5, 500, "BBU", "CDG", 50);
    Tickets item6 = new Tickets(6, 600, "BES", "DCA", 60);
    Tickets item7 = new Tickets(7, 700, "BIA", "DOH", 70);
    Tickets item8 = new Tickets(8, 800, "BJL", "EGN", 80);
    Tickets item9 = new Tickets(9, 900, "BMA", "EIM", 90);
    Tickets item10 = new Tickets(10, 1000, "BRN", "МОВ", 100);

    @BeforeEach
    public void setup() {
        repo.addTickets(item1);
        repo.addTickets(item2);
        repo.addTickets(item3);
        repo.addTickets(item4);
        repo.addTickets(item5);
        repo.addTickets(item6);
        repo.addTickets(item7);
        repo.addTickets(item8);
        repo.addTickets(item9);
        repo.addTickets(item10);
    }

    @Test
    public void shouldShowAllTickets() {

        Tickets[] expected = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10};
        Tickets[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeTicketsById() {

        repo.removeFilmById(item2.getId());

        Tickets[] expected = {item1, item3, item4, item5, item6, item7, item8, item9, item10};
        Tickets[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindById() {

        Tickets expected = item1;
        Tickets actual = repo.findById(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noFindByIdFound() {

        Tickets expected = null;
        Tickets actual = repo.findById(11);

        Assertions.assertEquals(expected, actual);
    }
}