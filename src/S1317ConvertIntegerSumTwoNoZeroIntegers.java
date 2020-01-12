public class S1317ConvertIntegerSumTwoNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        while (a <= n/2) {
            if (String.valueOf(a).contains("0")) {
                a++;
                continue;
            }
            int b = n-a;
            if (!String.valueOf(b).contains("0")) {
                return new int[]{a, b};
            }
            a++;
        }
        return null;
    }
}
