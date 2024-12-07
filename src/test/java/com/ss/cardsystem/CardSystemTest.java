package com.ss.cardsystem;

import com.ss.cardsystem.models.Card;
import com.ss.cardsystem.registry.StationRegistry;
import com.ss.cardsystem.registry.TransportRegistry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static com.ss.cardsystem.registry.TransportRegistry.TransportType.BUS;
import static com.ss.cardsystem.registry.TransportRegistry.TransportType.TUBE;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CardSystemTest {

    private CardSystem cardSystem;
    private Card card = Mockito.mock(Card.class);


    @BeforeAll
    static void setupCardSystem() {

        TransportRegistry.addType("Bus", BUS);
        TransportRegistry.addType("Tube", TUBE);

        StationRegistry.addStation("Holborn", 1);
        StationRegistry.addStation("Chelsea");
        StationRegistry.addStation("Earl’s Court", 1, 2);
        StationRegistry.addStation("Wimbledon", 3);
        StationRegistry.addStation("Hammersmith", 2);
    }

    @BeforeEach
    void setUp() {
        Mockito.when(card.id()).thenReturn(1);
        cardSystem = new CardSystem();
        card = new Card(1, 3000);
    }

    @Test
    public void rideBusWithCard_deduct() {

        cardSystem.checkIn(card, "Bus", "Earl’s Court");

        assertThat(card.balance(), is(2680));
    }

    @Test
    public void shouldThrowException_whenInsufficientBalance() {
        Card card = new Card(1, 100);

        Exception exception = assertThrowsExactly(IllegalArgumentException.class,
                () ->  cardSystem.checkIn(card, "Bus", "Earl’s Court"));

        assertThat(exception.getMessage(), is("insufficient balance"));
    }

    @Test
    public void checkOutFromBus() {
        cardSystem.checkIn(card, "Bus", "Earl’s Court");

        cardSystem.checkOut(card, "Chelsea");

        assertThat(card.balance(), is(2820));
    }

    @Test
    public void checkInTubeZone1_checkOutZone1() {
        cardSystem.checkIn(card, "Tube", "Holborn");

        cardSystem.checkOut(card, "Earl’s Court");

        assertThat(card.balance(), is(2750));
    }

    @Test
    public void checkInTubeZone1_checkOutZone2() {
        cardSystem.checkIn(card, "Tube", "Holborn");

        cardSystem.checkOut(card, "Hammersmith");

        assertThat(card.balance(), is(2700));
    }

    @ParameterizedTest
    @CsvSource({
            "Holborn,Earl’s Court,2750",
            "Holborn,Hammersmith,2700",
            "Holborn,Wimbledon,2680",

            "Earl’s Court,Holborn,2750",
            "Earl’s Court,Hammersmith,2775",
            "Earl’s Court,Wimbledon,2775",

            "Hammersmith,Earl’s Court,2775",
            "Hammersmith,Holborn,2750",
            "Hammersmith,Wimbledon,2775",

            "Wimbledon,Earl’s Court,2775",
            "Wimbledon,Holborn,2680",
            "Wimbledon,Hammersmith,2775",
    })
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String from, String to, int balance) {
        cardSystem.checkIn(card, "Tube", from);

        cardSystem.checkOut(card, to);

        assertThat(card.balance(), is(balance));
    }
}