package org.example;

public class Decoder {


    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static String decodeWord(String encodedWord) {
        if (containsNumber(encodedWord)) {
            return decodeVowels(encodedWord);
        } else {
            return decodeLetters(encodedWord);
        }
    }

    private static String decodeVowels(String encodedWord) {
        encodedWord = encodedWord.replaceAll("1", "a")
                .replaceAll("2", "e")
                .replaceAll("3", "i")
                .replaceAll("4", "o")
                .replaceAll("5", "u");
        return encodedWord;
    }

    private static String decodeLetters(String encodedWord) {
        StringBuilder decodedWord = new StringBuilder();
        for (char c : encodedWord.toCharArray()) {
            boolean isUpperCase = Character.isUpperCase(c);
            c = Character.toLowerCase(c);
            int index = 25;
            while (index >= 0) {
                if (c == ALPHABET[index] && !isVowel(c)) {
                    char checkVowel = ALPHABET[index - 1];
                    index = isVowel(checkVowel) ? index - 2 : index - 1;
                    break;
                }
                index--;
            }
            if (index >= 0) {
                char resultChar = ALPHABET[index];
                if (isUpperCase) {
                    resultChar = Character.toUpperCase(resultChar);
                }
                decodedWord.append(resultChar);
            } else {
                decodedWord.append(c);
            }
        }
        return decodedWord.toString();
    }

    private static boolean containsNumber(String word) {
        return word.matches(".*\\d.*");
    }

    private static boolean isVowel(char c) {
        return new String(VOWELS).indexOf(Character.toLowerCase(c)) != -1;
    }

}
