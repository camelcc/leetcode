public class S0479LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = max*10;
        }
        int min = max/10;
        max = max-1;

        boolean findPalBefore = false;
        long pal = 0;
        long minPalSum = (long)min+(long)min;

        long sum = (long)max+(long)max;
        while (sum >= minPalSum) {
            int v1 = max;
            int v2 = (int)(sum-v1);
            while ((v1 >= 1 && v1 <= max) && (v2 >= 1 && v2 <= max) && v1 >= v2) {
                long v = (long)v1*(long)v2;
                if (isPalindrome(v)) {
                    if (pal < v) {
                        pal = v;
                    }
                    if (!findPalBefore) {
                        findPalBefore = true;
                        minPalSum = (sum/2)*2;
                    }
                }
                v1--;
                v2++;
            }
            sum--;
        }
        if (pal != 0) {
            return (int)(pal%1337);
        }
        return -1;
    }

    private boolean isPalindrome(long n) {
        if (n%10 == 0) {
            return false;
        }

        long r = 0;
        while (n > r) {
            r = 10*r + n%10;
            n = n/10;
        }

        return n == r || (n == r/10);
    }
}
