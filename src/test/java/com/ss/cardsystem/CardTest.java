package com.ss.cardsystem;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CardTest {

    @Test
    public void hasValidCard() {
        Card card = new Card(1000);
        assertThat(card.balance(), is(1000));
    }


}
