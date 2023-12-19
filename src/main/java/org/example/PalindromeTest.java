package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class PalindromeTest{
        @Test
        public void testIsPalindromeTrue() {
            assertTrue(PalindromeChecker.isPalindrome("Racecar"));
            assertTrue(PalindromeChecker.isPalindrome("No lemon no melon"));
            assertTrue(PalindromeChecker.isPalindrome("Was it a cat i saw"));
        }

        @Test
        public void testIsPalindromeFalse() {
            assertFalse(PalindromeChecker.isPalindrome("what is the meaning of life"));
            assertFalse(PalindromeChecker.isPalindrome("what"));
        }
    }

