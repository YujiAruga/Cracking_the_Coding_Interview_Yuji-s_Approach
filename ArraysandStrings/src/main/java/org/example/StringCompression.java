package org.example;

public class StringCompression {
    public String stringCompression(String s) {
        StringBuilder sb = new StringBuilder();
        char currentChar = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != currentChar) {
                sb.append(currentChar);
                sb.append(count);
                currentChar = s.charAt(i);
                count = 0;
            }
            count++;
        }

        sb.append(currentChar);
        sb.append(count);

        if (s.length() <= sb.length()) {
            return s;
        }
        else {
            return sb.toString();
        }
    }


    // Sample solution 1
    public String compressBad(String str) {
        String compressedString = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If next character is different than current, append this char to result.
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }

        return compressedString.length() < str.length() ? compressedString : str;
    }


    // Sample solution 2
    public String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /*
            If next character is different than current, append this char to result.
             */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }


    // Sample solution 3
    public String compressSample2(String str) {
        // Check final length and return input string if it would be longer.
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder(finalLength); // initial capacity
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If next character is different than current, append this char to result.
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.toString();
    }

    private int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If next character is different than current, increase the length.
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }

        return compressedLength;
    }
}
