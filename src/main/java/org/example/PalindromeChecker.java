package org.example;

public class PalindromeChecker {
    public static boolean isPalindrome(String word) {
        String cleanWord = word.replaceAll("\\s", "").toLowerCase();
        int length = cleanWord.length();

        for (int i = 0, j = length - 1; i < j; i++, j--) {
            char firstChar = cleanWord.charAt(i);
            char lastChar = cleanWord.charAt(j);

            if (firstChar != lastChar) {
                System.out.println(word + " не є паліндромом.");
                return false;
            }
        }

        System.out.println(word + " є паліндромом.");
        return true;
    }
}
