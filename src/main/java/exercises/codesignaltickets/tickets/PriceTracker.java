package exercises.codesignaltickets.tickets;

public interface PriceTracker {
    /**
     * @param originAirport      the name of the airport you are flying from
     * @param destinationAirport the name of the airport you are flying to
     * @return the price of the cheapest DIRECT flight
     * from the originAirport to the destinationAirport.
     * Return -1 in case if there are no direct flights.
     */
    public int getCheapestTicketPrice(String originAirport, String destinationAirport);
}
