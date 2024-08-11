package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsUniqueTest {
    @Test
    void isUnique() {
        IsUnique isUnique = new IsUnique();
        boolean result = isUnique.isUnique("abc");
        assertTrue(result);

        boolean result2 = isUnique.isUnique("abcddd");
        assertFalse(result2);
    }

}