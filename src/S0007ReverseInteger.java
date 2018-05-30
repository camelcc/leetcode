public class S0007ReverseInteger {
    public int reverse(int x) {
        boolean lessThanZero = x < 0;
        int abs = x;
        if (lessThanZero) {
            abs = -x;
            if (abs < 0) {
                return 0; // overflow
            }
        }

        int reversed = 0;
        while (abs > 0) {
            if ((Integer.MAX_VALUE - abs%10)/10 < reversed) {
                return 0;
            }
            reversed = 10 * reversed + abs % 10;
            abs = abs / 10;
        }
        if (reversed < 0) { // overflow
            return 0;
        }

        if (lessThanZero) {
            return 0 - reversed;
        } else {
            return reversed;
        }
    }
}
