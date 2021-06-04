import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-string-sorted/discuss/1166535/Java-66ms-No-Complex-Maths-100-Explained
public class S1830MinimumNumberOperationsMakeStringSorted {
    public int f = 1;
    Map<Integer, BigInteger> factorMemo = new HashMap();

    public int makeStringSorted(String s) {
        int[] occurrences = new int[26];
        populateOccurrences(occurrences, s);
        int totalLength = s.length();

        BigInteger result = BigInteger.ZERO;
        BigInteger possibilities = numberOfPossibilities(occurrences, totalLength);
        while(totalLength > 1) {
            // We start calculating after the first step
            if(totalLength < s.length()) {
                int previousOccurrences = occurrences[s.charAt(s.length() - totalLength - 1) - 'a'] + 1;
                possibilities = possibilities.multiply(BigInteger.valueOf(previousOccurrences)).divide(BigInteger.valueOf(totalLength+1));
            }
            BigInteger numberOfOccurrencesBefore = numberOfOccurrencesBefore(occurrences, s.charAt(s.length() - totalLength));
            BigInteger currentResult = possibilities.multiply(numberOfOccurrencesBefore).divide(BigInteger.valueOf(totalLength));
            occurrences[s.charAt(s.length() - totalLength) - 'a'] -= 1;
            result = result.add(currentResult);
            totalLength--;
        }

        return result.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public void populateOccurrences(int[] occurrences, String s) {
        for(char c: s.toCharArray()) {
            occurrences[c - 'a'] += 1;
        }
    }

    public BigInteger numberOfOccurrencesBefore(int[] occurrences, char character) {
        int result = 0;
        for(int i=0; i<character-'a'; i++) {
            result += occurrences[i];
        }
        return BigInteger.valueOf(result);
    }

    public BigInteger numberOfPossibilities(int[] occurrences, int totalSum) {
        BigInteger result = factorial(totalSum);
        for(int i=0; i<occurrences.length; i++) {
            result = result.divide(factorial(occurrences[i]));
        }
        return result;
    }

    public BigInteger factorial(int n) {
        if(factorMemo.get(n) != null) {
            return factorMemo.get(n);
        }
        BigInteger result = BigInteger.ONE;
        for(int i=1; i<=n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
            factorMemo.put(i, result);
        }
        factorMemo.put(n, result);
        return result;
    }
}
