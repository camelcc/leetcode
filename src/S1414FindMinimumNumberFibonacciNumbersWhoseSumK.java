import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class S1414FindMinimumNumberFibonacciNumbersWhoseSumK {
    public int findMinFibonacciNumbers(int k) {
        if (k == 1) {
            return 1;
        } else if (k == 2) {
            return 1;
        }
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        dp.put(2, 1);

        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        int a = 1, b = 1, c = 2;
        while (c <= k) {
            fib.add(c);
            a = b;
            b = c;
            c = a+b;
        }

        int res = 1, remains = k-fib.get(fib.size()-1);
        while (remains > 0) {
            int index = Collections.binarySearch(fib, remains);
            if (index >= 0) {
                res++;
                return res;
            }
            index = -(index+1)-1;
            res++;
            remains -= fib.get(index);
        }
        return res;
    }
}
