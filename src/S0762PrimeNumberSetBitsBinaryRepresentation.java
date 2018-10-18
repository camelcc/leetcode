import java.util.HashSet;

public class S0762PrimeNumberSetBitsBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        HashSet<Integer> primes = new HashSet<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);
        primes.add(23);
        primes.add(31);
        int cnt = 0;
        for (int i = L; i <= R; i++) {
            if (primes.contains(setbits(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    private int setbits(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt += (num%2 == 1 ? 1 : 0);
            num = num/2;
        }
        return cnt;
    }
}
