import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S1845SeatReservationManager {
    public static class SeatManager {
        List<Integer> seats;

        public SeatManager(int n) {
            seats = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                seats.add(i);
            }
        }

        public int reserve() {
            return seats.remove(0);
        }

        public void unreserve(int seatNumber) {
            int p = Collections.binarySearch(seats, seatNumber);
            if (p < 0) {
                p = -(p+1);
            }
            seats.add(p, seatNumber);
        }
    }
}
