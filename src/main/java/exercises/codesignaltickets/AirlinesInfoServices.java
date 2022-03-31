package exercises.codesignaltickets;

import java.util.List;

public interface AirlinesInfoServices {
    /**
     * @return a list of the names of the available airlines
     */
    public List<String> getAvailableAirlines();

    /**
     * @param airline            the name of the airline
     * @param originAirport      the name of the source airport
     * @param destinationAirport the name of the destination airport
     * @return the price of the ticket from originAirport to destinationAirport
     * when using the services of the airport with the id airlineId
     */
    public int getTicketPrice(String airline, String originAirport, String destinationAirport);
}
