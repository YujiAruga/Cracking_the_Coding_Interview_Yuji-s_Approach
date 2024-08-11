package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroMatrixTest {

    @Test
    void allEntriesShouldBeZero() {
        ZeroMatrix zeroMatrix = new ZeroMatrix();
        int[][] matrix = {{0, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        int[][] expcted = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        ZeroMatrix.zeroMatrix(matrix);
        assertArrayEquals(matrix, expcted);
    }

}