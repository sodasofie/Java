package org.example;

public class Main {

    public static void main(String[] args) {

        String encodedMessage1 = "t2st3ng";
        String encodedMessage2 = "4r1ng2";
        String encodedMessage3 = "xjav it vjit poptepte";

        String decodedMessage1 = Decoder.decodeWord(encodedMessage1);
        String decodedMessage2 = Decoder.decodeWord(encodedMessage2);
        String decodedMessage3 = Decoder.decodeWord(encodedMessage3);


        runTests(encodedMessage1,  decodedMessage1, "testing");
        runTests(encodedMessage2,  decodedMessage2, "incorrect by purpose");
        runTests(encodedMessage3,  decodedMessage3, "what is this nonsense");
    }

    private static void runTests(String encodedMessage, String decodedMessage, String expected) {
        System.out.println("Running Tests for: " + encodedMessage);
        System.out.println("Decoded Message: " + decodedMessage);

        if (decodedMessage.equals(expected)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }
        System.out.println("------------------------");
    }

}