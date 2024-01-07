import org.example.BookingSystem;
import java.util.Arrays;

public class BookingSystemTest {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();


        bookingSystem.printSeatingArrangement(0);

        System.out.println("Наявність 2 місць в Залі 0: " + bookingSystem.checkAvailability(0, 2));

        int[] seatsToBook = bookingSystem.findBestAvailable(0, 2);
        System.out.println("Найкращі наявні 2 місця  в Залі 0: " + Arrays.toString(Arrays.stream(seatsToBook).map(i -> i + 1).toArray()));

        bookingSystem.bookSeats(0, 0, seatsToBook);
        System.out.println("Зал 0 після бронювання 2 місць: ");
        bookingSystem.printSeatingArrangement(0);

        bookingSystem.cancelBooking(0, 0, seatsToBook);
        System.out.println("Зал 0 після скасування броні на місця: ");
        bookingSystem.printSeatingArrangement(0);

        bookingSystem.autoBook(0, 5);

        System.out.println("Зал 0 після автобронювання 5 місць:");
        bookingSystem.printSeatingArrangement(0);
    }
}