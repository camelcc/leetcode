import java.util.Arrays;

public class S2037MinimumNumberMovesSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            int seat = seats[i], student = students[i];
            res += Math.abs(seat-student);
        }
        return res;
    }
}
