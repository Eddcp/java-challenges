package codesignaltickets;


import exercises.codesignaltickets.AirlinesInfoServices;
import exercises.codesignaltickets.tickets.PriceTracker;
import exercises.codesignaltickets.tickets.PriceTrackerImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class FunctionalTests {

    private static final String originAirport = "Airport 0";
    private static final String destinationAirport = "Airport 1";

    private static final int NUMBER_OF_AIRLINES = 50;
    private static Map<String, Airline> airlines;
    private static List<Airline.FlightKey> allPossibleFlights;

    private static int expectedPriceInLastTest;

    @BeforeAll
    public static void setUp() {
        airlines = new HashMap<>(NUMBER_OF_AIRLINES);

        airlines.put("Airline 0", new Airline(30));
        airlines.get("Airline 0").setTicketPrice(originAirport, destinationAirport, 1000);

        airlines.put("Airline 1", new Airline(60));
        airlines.get("Airline 1").setTicketPrice(originAirport, destinationAirport, 200);

        airlines.put("Airline 2", new Airline(45));
        airlines.get("Airline 2").setTicketPrice(originAirport, destinationAirport, 800);

        airlines.put("Airline 3", new Airline(100));
        airlines.get("Airline 3").setTicketPrice(originAirport, destinationAirport, 400);

        airlines.put("Airline 4", new Airline(120));
        airlines.get("Airline 4").setTicketPrice(originAirport, destinationAirport, 300);

        airlines.put("Airline 5", new Airline(75));
        airlines.get("Airline 5").setTicketPrice(originAirport, destinationAirport, 600);

        airlines.put("Airline 6", new Airline(45));

        airlines.put("Airline 7", new Airline(60));
        airlines.get("Airline 7").setTicketPrice(originAirport, destinationAirport, 300);

        airlines.put("Airline 8", new Airline(45));

        airlines.put("Airline 9", new Airline(60));
        airlines.get("Airline 9").setTicketPrice(originAirport, destinationAirport, 700);

        expectedPriceInLastTest = 200;
        final Random random = new Random(42);
        for (int i = 10; i < NUMBER_OF_AIRLINES; i++) {
            String airlineName = "Airline " + i;
            airlines.put(airlineName, new Airline(random.nextInt(50)));

            int price = random.nextInt(1000);
            if (price >= 50) {
                expectedPriceInLastTest = Math.min(expectedPriceInLastTest, price);
                airlines.get(airlineName).setTicketPrice(originAirport, destinationAirport, price);
            }
        }

        allPossibleFlights = List.of(
                new Airline.FlightKey(originAirport, destinationAirport)
        );
    }

    private AirlinesInfoServices airlinesInfoServices;
    private PriceTracker priceTracker;

    public void setAirlineServicesBehavior(List<String> availableAirlines, int delayTime) {
        Mockito.when(this.airlinesInfoServices.getAvailableAirlines()).thenAnswer((invocation) -> {
            Thread.sleep(delayTime);
            return availableAirlines;
        });
        for (String airlineName : availableAirlines) {
            Airline airline = airlines.get(airlineName);
            for (Airline.FlightKey flight : allPossibleFlights) {
                Mockito.when(this.airlinesInfoServices.getTicketPrice(airlineName, flight.originAirport, flight.destinationAirport))
                        .thenAnswer((invocation) -> {
                            return airline.getTicketPrice(flight.originAirport, flight.destinationAirport);
                        });
            }
        }
    }

    @BeforeEach
    public void setUpBeforeEach() {
        this.airlinesInfoServices = Mockito.mock(AirlinesInfoServices.class);
        this.priceTracker = new PriceTrackerImpl(this.airlinesInfoServices);
    }

    private static Stream<Arguments> getAvailableAirlinesForTest() {
        List<String> availableAirlinesInLastTest = new ArrayList<>(airlines.keySet());
        return Stream.of(
                Arguments.of(List.of("Airline 0", "Airline 1"), 10, 200),
                Arguments.of(List.of("Airline 2", "Airline 4", "Airline 8"), 20, 300),
                Arguments.of(List.of("Airline 0", "Airline 3", "Airline 5"), 10, 400),
                Arguments.of(Collections.emptyList(), 10, -1),
                Arguments.of(List.of("Airline 6"), 10, -1),
                Arguments.of(List.of("Airline 4", "Airline 5", "Airline 8", "Airline 9"), 10, 300),
                Arguments.of(
                        List.of(
                                "Airline 0",
                                "Airline 1",
                                "Airline 2",
                                "Airline 3",
                                "Airline 4",
                                "Airline 5",
                                "Airline 6",
                                "Airline 7",
                                "Airline 8",
                                "Airline 9"
                        ),
                        50, 200
                ),
                Arguments.of(availableAirlinesInLastTest, 20, expectedPriceInLastTest)
        );
    }

    @ParameterizedTest
    @MethodSource("getAvailableAirlinesForTest")
    void basicTests(List<String> availableAirlines, int delayTime, int expectedPrice) {
        this.setAirlineServicesBehavior(availableAirlines, delayTime);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            Assertions.assertEquals(
                    expectedPrice,
                    this.priceTracker.getCheapestTicketPrice(originAirport, destinationAirport)
            );
        });
    }
}

