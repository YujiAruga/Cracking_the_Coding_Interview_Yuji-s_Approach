package org.example;

public class URLify {
    public String urlify(String input, int len) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (chars[i+1] != ' ' && chars[i+2] != ' ') {
                    chars = shift(chars, 2, i+1);
                    chars[i] = '%';
                    chars[i+1] = '2';
                    chars[i+2] = '0';
                }
                else if (chars[i+2] != ' ') {
                    chars = shift(chars, 1, i+1);
                    chars[i] = '%';
                    chars[i+1] = '2';
                    chars[i+2] = '0';
                }
                else {
                    chars[i] = '%';
                    chars[i+1] = '2';
                    chars[i+2] = '0';
                }
            }
        }

        return new String(chars);
    }

    private char[] shift(char[] chars, int right, int index) {
        for (int i = index; i < chars.length; i++) {
            chars[i + right] = chars[i];
        }

        return chars;
    }

    public void urlifySample1(char[] str, int trueLength) {
        int numberOfSpaces = countOfChar(str, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;

        /*
        If there are excess spaces, add a null character. This indicates that the
        spaces after that point have not been replaced with %20.
         */
        if (newIndex + 1 < str.length) str[newIndex] = '\0';
        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
            if (str[oldIndex] == ' ') { /* Insert %20 */
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
            }
            else {
                str[newIndex] = str[oldIndex];
                newIndex -= 1;
            }
        }

    }

    private int countOfChar(char[] str, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (str[i] == target) {
                count++;
            }
        }
        return count;
    }
}
