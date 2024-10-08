package org.example;

public class StringRotation {

    public boolean isRotation(String s1, String s2) {
        int len = s1.length();

        // Check that s1 and s2 are equal length and not empty
        if (len == s2.length() && len > 0) {
            // Concatenate s1 and s1 within new buffer
            String s1s1 = s1 + s1;
            return isRotation(s1s1, s2);
        }
        return false;
    }

    private boolean isSubstring(String s1, String s2) {
        return false;
    }
}
