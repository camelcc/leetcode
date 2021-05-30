public class S1796SecondLargestDigitString {
    public int secondHighest(String s) {
        int largest = -1, second = -1;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                int d = c-'0';
                if (d > largest) {
                    second = largest;
                    largest = d;
                } else if (d < largest && d > second) {
                    second = d;
                }
            }
        }
        return second;
    }
}
