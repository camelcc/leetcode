import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-ways-to-make-array-with-product/discuss/1031686/Java-or-Maths-solution-or-Faster-than-65
public class S1735CountWaysMakeArrayWithProduct {
    public int[] waysToFillArray(int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; ++i)
        {
            int sum = queries[i][1];
            int arrSize = queries[i][0];
            HashMap<Integer, Integer> map = getPrimeFactors(sum);
            //System.out.println("Map for number " + sum + " is: " + map);
            if(map.size() == 0) {
                ans[i] = sum == 1 ? 1 : arrSize;
            } else {
                long value = 1;
                for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    long tempValue = getCombination(arrSize + entry.getValue() - 1, entry.getValue()); //Combinations - (n+r-1)Cr
                    value = (value * tempValue) % 1000000007;
                }
                ans[i] = (int) (value);
            }
        }
        return ans;
    }

    public long getCombination(int n, int r) {
        BigInteger value = new BigInteger("1");
        long toDivide = 1;
        for(int i = 1; i <= r; ++i) {
            value = value.multiply(new BigInteger((n - i + 1) + ""));
            toDivide *= i;
        }
        value = value.divide(new BigInteger(toDivide + ""));
        value = value.remainder(new BigInteger("1000000007"));
        return value.longValue();
    }

    public HashMap getPrimeFactors(int n) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 2; i <=n; ++i ) {
            if (n%i == 0) {
                int count = 0;
                while(n % i == 0) {
                    count++;
                    n = n/i;
                }
                map.put(i, count);
            }

        }
        return map;
    }
}
