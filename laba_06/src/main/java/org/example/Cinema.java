package org.example;
public class Cinema {
    private int[][][] seats;

    public Cinema() {
        seats = new int[5][10][20];
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Розташування місць для сидіння в Залі " + hallNumber + ":");
        for (int row = 0; row < 10; row++) {
            for (int seat = 0; seat < 20; seat++) {
                if (seats[hallNumber][row][seat] == 0) {
                    System.out.print("O " );
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < 10; row++) {
            for (int seat = 0; seat <= 20 - numSeats; seat++) {
                boolean isAvailable = true;
                for (int i = seat; i < seat + numSeats; i++) {
                    if (seats[hallNumber][row][i] == 1) {
                        isAvailable = false;
                        break;
                    }
                }
                if (isAvailable) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] findBestAvailable(int hallNumber, int numSeats) {
        int bestRow = -1;
        int bestSeatStart = -1;
        int bestMidPoint = Integer.MAX_VALUE;

        for (int row = 0; row < 10; row++) {
            for (int seat = 0; seat <= 20 - numSeats; seat++) {
                int midPoint = Math.abs(seat + numSeats / 2 - 9);

                if (midPoint < bestMidPoint) {
                    boolean isAvailable = true;
                    for (int i = seat; i < seat + numSeats; i++) {
                        if (seats[hallNumber][row][i] == 1) {
                            isAvailable = false;
                            break;
                        }
                    }

                    if (isAvailable) {
                        bestRow = row;
                        bestSeatStart = seat;
                        bestMidPoint = midPoint;
                    }
                }
            }
        }

        if (bestRow != -1 && bestSeatStart != -1) {
            int[] bestSeats = new int[numSeats];
            for (int i = 0; i < numSeats; i++) {
                seats[hallNumber][bestRow][bestSeatStart + i] = 1;
                bestSeats[i] = bestSeatStart + i + 1;
            }
            return bestSeats;
        }

        return null;
    }

    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            this.seats[hallNumber][row][seat - 1] = 1;
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            this.seats[hallNumber][row][seat - 1] = 0;
        }
    }
}


