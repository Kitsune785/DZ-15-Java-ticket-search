package org.example.src.Manager;

import org.example.src.domain.Tickets;
import org.example.src.repository.TicketsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketsManagerTest {

    TicketsRepository repo = new TicketsRepository();
    TicketsManager manager = new TicketsManager(repo);

    Tickets item1 = new Tickets(1, 100, "AEP", "BRU", 10);
    Tickets item2 = new Tickets(2, 200, "ARN", "BTS", 20);
    Tickets item3 = new Tickets(3, 450, "AUH", "BUD", 30);
    Tickets item4 = new Tickets(4, 400, "AZI", "BWI", 40);
    Tickets item5 = new Tickets(5, 500, "BBU", "CDG", 50);
    Tickets item6 = new Tickets(6, 600, "BES", "DCA", 60);
    Tickets item7 = new Tickets(7, 700, "BIA", "DOH", 70);
    Tickets item8 = new Tickets(8, 800, "BJL", "EGN", 80);
    Tickets item9 = new Tickets(9, 900, "BMA", "EIM", 90);
    Tickets item10 = new Tickets(10, 1000, "BRN", "МОВ", 100);

    @BeforeEach
    public void setup() {
        manager.addNewTickets(item5);       // добавление не попорядку, для проверки сортировки
        manager.addNewTickets(item4);
        manager.addNewTickets(item6);
        manager.addNewTickets(item2);
        manager.addNewTickets(item1);
        manager.addNewTickets(item3);
        manager.addNewTickets(item8);
        manager.addNewTickets(item9);
        manager.addNewTickets(item7);
    }

    @Test
    public void shouldNotFindTravel() {

        Tickets[] expected = new Tickets[]{};
        Tickets[] actual = manager.findAll(null, null);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortPrice() {

        Tickets[] expected = new Tickets[]{item1, item2, item3, item4, item5, item6, item7, item8, item9};
        Tickets[] actual = new Tickets[]{item1, item2, item4, item3, item5, item6, item7, item8, item9}; // 3 дороже 4-го
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingТotАllАdded() {

        Tickets[] expected = new Tickets[]{item1, item2, item3, item4, item5};
        Tickets[] actual = new Tickets[]{item1, item2, item4, item3, item5}; // 3 дороже 4-го
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTravelTime() {

        Tickets[] expected = new Tickets[]{item1};
        Tickets[] actual = manager.findAll("AEP", "BRU");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldWrongDepartureAirport() {

        Tickets[] expected = new Tickets[]{};
        Tickets[] actual = manager.findAll("", "EIM");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldWrongArrivalАirport() {

        Tickets[] expected = new Tickets[]{};
        Tickets[] actual = manager.findAll("BIA", "");

        Assertions.assertArrayEquals(expected, actual);
    }
}