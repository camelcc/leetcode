public class S1033MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        if (b > c) {
            int t = b;
            b = c;
            c = t;
        }
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        assert a < b && b < c;
        int max = c-a+1-3;
        int min = 2;
        if (a+1 == b && b+1 == c) {
            min = 0;
        } else if (a+1 == b || b+1 == c || a+2 == b || b+2 == c) {
            min = 1;
        }
        return new int[]{min, max};
    }
}
