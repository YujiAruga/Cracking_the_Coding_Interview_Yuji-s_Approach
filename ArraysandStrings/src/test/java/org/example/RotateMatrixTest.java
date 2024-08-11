package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    @Test
    void testRotateMatrix123456789To741852963() {
        RotateMatrix rotateMatrix = new RotateMatrix();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertArrayEquals(rotateMatrix.rotateMatrix1(matrix), expected);
    }

}