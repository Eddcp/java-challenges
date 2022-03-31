package codesignaltickets;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class Airline {

    private final int delayTime;
    private Map<FlightKey, Integer> ticketPrices;

    public Airline(int delayTime) {
        this.delayTime = delayTime;
        this.ticketPrices = new HashMap<>();
    }

    public Set<FlightKey> getAvailableFlights() {
        return this.ticketPrices.keySet();
    }

    public int getTicketPrice(String originAirport, String destinationAirport) throws InterruptedException {
        Thread.sleep(this.delayTime);
        FlightKey flightKey = new FlightKey(originAirport, destinationAirport);
        return this.ticketPrices.getOrDefault(flightKey, -1);
    }

    public void setTicketPrice(String originAirport, String destinationAirport, int price) {
        this.ticketPrices.put(new FlightKey(originAirport, destinationAirport), price);
    }

    public static class FlightKey {
        public final String originAirport;
        public final String destinationAirport;

        public FlightKey(String originAirport, String destinationAirport) {
            this.originAirport = originAirport;
            this.destinationAirport = destinationAirport;
        }

        @Override
        public boolean equals(Object o) {
            // self check
            if (this == o) {
                return true;
            }
            // null check
            if (o == null) {
                return false;
            }
            // type check and cast
            if (getClass() != o.getClass()) {
                return false;
            }
            FlightKey flightKey = (FlightKey) o;
            // field comparison
            return Objects.equals(this.originAirport, flightKey.originAirport)
                    && Objects.equals(this.destinationAirport, flightKey.destinationAirport);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.originAirport, this.destinationAirport);
        }
    }
}
