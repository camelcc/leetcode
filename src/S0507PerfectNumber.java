import java.util.ArrayList;
import java.util.List;

public class S0507PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0 || num %2 == 1) {
            return false;
        }

        List<Integer> dividers = new ArrayList<>();
        dividers.add(1);
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num%i == 0) {
                int d = num/i;
                dividers.add(i);
                if (d != i) {
                    dividers.add(d);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < dividers.size(); i++) {
            sum += dividers.get(i);
        }
        return sum == num;
    }
}
