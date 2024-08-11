package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneAwayTest {

    @Test
    void paleIsOneAwayFromple() {
        OneAway oneAway = new OneAway();
        assertEquals(oneAway.oneAway("pale", "ple"), true);
    }



}