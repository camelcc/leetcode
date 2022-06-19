public class S2310SumNumbersWithUnitsDigitK {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        if (k == 0) {
            if (num%10 == 0) {
                return 1;
            }
            return -1;
        }
        for (int i = 1; i < 10; i++) {
            int v = i*k;
            if (v > num) {
                break;
            } else { // v <= num
                if (v%10 == num%10) {
                    return i;
                }
            }
        }
        if (num < 10*k) {
            return -1;
        }
        if (num%10 == 0) {
            return 10;
        } else {
            return -1;
        }
    }
}
