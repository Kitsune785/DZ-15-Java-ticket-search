package org.example.src.domain;

public class Tickets implements Comparable<Tickets> {

    protected int id;
    protected int price;
    protected String departureAirport;
    protected String arrivalАirport;
    protected int travelTime;

    public Tickets() {
    }

    public Tickets(int id, int price, String departureAirport, String arrivalАirport, int travelTime) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalАirport = arrivalАirport;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public String getArrivalАirport() {
        return arrivalАirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public int compareTo(Tickets comparePrice) {
        return this.price - comparePrice.price;
    }
}