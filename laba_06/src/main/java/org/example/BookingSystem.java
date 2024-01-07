package org.example;
import java.util.Arrays;

public class BookingSystem {
    private Cinema[] halls;

    public BookingSystem() {
        halls = new Cinema[5];
        for (int i = 0; i < 5; i++) {
            halls[i] = new Cinema();
        }
    }

    public void printSeatingArrangement(int hallNumber) {
        halls[hallNumber].printSeatingArrangement(hallNumber);
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        return halls[hallNumber].checkAvailability(hallNumber, numSeats);
    }

    public int[] findBestAvailable(int hallNumber, int numSeats) {
        return halls[hallNumber].findBestAvailable(hallNumber, numSeats);
    }

    public void bookSeats(int hallNumber, int row, int[] seats) {
        halls[hallNumber].bookSeats(hallNumber, row, seats);
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        halls[hallNumber].cancelBooking(hallNumber, row, seats);
    }

    public void autoBook(int hallNumber, int numSeats) {
        int[] bestSeats = findBestAvailable(hallNumber, numSeats);
        if (bestSeats != null) {
            bookSeats(hallNumber, 0, bestSeats);
            System.out.println("Місця " + Arrays.toString(bestSeats) + " були автоматично заброньовані в Залі " + hallNumber);
        } else {
            System.out.println("Немає наявних місць в Залі" + hallNumber + " для " + numSeats + " місць підряд.");
        }
    }

}


