package exercises.codesignaltickets.tickets;


import exercises.codesignaltickets.AirlinesInfoServices;

import java.util.TreeMap;
import java.util.stream.Collectors;

public class PriceTrackerImpl implements PriceTracker {

    private final AirlinesInfoServices airlinesInfoServices;

    public PriceTrackerImpl(AirlinesInfoServices airlinesInfoServices) {
        this.airlinesInfoServices = airlinesInfoServices;
    }

    @Override
    public int getCheapestTicketPrice(String originAirport, String destinationAirport) {
        // Use the provided services in order to get the price of the cheapest DIRECT flight.
        try {
            var availableAirlines = this.airlinesInfoServices.getAvailableAirlines();
            var minimun = availableAirlines.parallelStream()
                    .collect(Collectors.groupingBy(x -> this.airlinesInfoServices.getTicketPrice(x, originAirport, destinationAirport), TreeMap::new, Collectors.toList()));
            return minimun.firstEntry().getKey();

        } catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }
}