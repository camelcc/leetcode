import java.util.*;

public class S1238CircularPermutationBinaryRepresentation {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();

        if (n == 1) {
            assert start == 1 || start == 0;
            res.add(start);
            res.add(start == 1 ? 0 : 1);
            return res;
        }

        // n > 1
        int mask = ((0x1<<n)-1)>>1;
        List<Integer> permutation = circularPermutation(n-1, (start & mask));
        int firstBit = (start&(0x1<<(n-1))) == 0 ? 0 : 1;

        int curVal = firstBit << (n-1);
        for (int i : permutation) {
            res.add(curVal | i);
        }
        int othVal = (firstBit == 1 ? 0 : 1) << (n-1);
        for (int i = permutation.size()-1; i >= 0; i--) {
            res.add(othVal | permutation.get(i));
        }

        return res;
    }
}
