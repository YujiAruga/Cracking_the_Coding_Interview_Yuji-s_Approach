package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

    @Test
    void compressaaabbbbbccca() {
        StringCompression compression = new StringCompression();
        assertEquals(compression.stringCompression("aaabbbbbccca"), "a3b5c3a1");
    }

    @Test
    void cmpressabcdefg() {
        StringCompression compression = new StringCompression();
        assertEquals(compression.stringCompression("abcdefg"), "abcdefg");
    }

}