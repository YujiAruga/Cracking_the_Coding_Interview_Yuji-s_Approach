package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLifyTest {

    @Test
    void urlify() {
        URLify urlify = new URLify();
        assertEquals(urlify.urlify("Mr John Smith", 13), "Mr%20John%20Smith");
    }

}