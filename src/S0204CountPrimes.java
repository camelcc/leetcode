public class S0204CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] notPrims = new boolean[n];
        notPrims[0] = true;
        notPrims[1] = true;
        notPrims[2] = false;
        int count = 1;
        for (int i = 3; i < n; i+=2) {
            if (!notPrims[i]) {
                count++;
                for (int j = i+i; j < n; j+=i) {
                    notPrims[j] = true;
                }
            }
        }
        return count;
    }
}
