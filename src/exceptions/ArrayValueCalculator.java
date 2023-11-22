package exceptions;

import java.util.Arrays;

public class ArrayValueCalculator {

    public static void main(String[] args) {
        String[][] inputMatrix = {
                {"4", "2", "3", "4"},
                {"5", "7", "7", "8"},
                {"9", "10", "11", "6"},
                {"1", "14", "a", "16"}
        };

        try {
            int result = doCalc(inputMatrix);
            System.out.println("Calculation result: " + result);
        } catch ( ArraySizeException | ArrayDataException e ) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static int doCalc(String[][] inputMatrix) throws ArraySizeException, ArrayDataException {
        if ( inputMatrix.length != 4 || Arrays.stream(inputMatrix).anyMatch(row -> row.length != 4) ) {
            throw new ArraySizeException("Array must have dimensions 4x4");
        }

        int sum = 0;

        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 4; j++ ) {
                try {
                    sum += Integer.parseInt(inputMatrix[i][j]);
                } catch ( NumberFormatException e ) {
                    throw new ArrayDataException("Error converting to int in cell [" + i + "][" + j + "]. Invalid data.", e);
                }
            }
        }
        return sum;
    }
}
