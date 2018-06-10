import java.util.ArrayList;
import java.util.List;

public class S0412FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String val = String.valueOf(i);
            boolean isFizz = false;
            if (i % 3 == 0) {
                val = "Fizz";
                isFizz = true;
            }
            if (i % 5 == 0) {
                val = isFizz ? "FizzBuzz" : "Buzz";
            }
            res.add(val);
        }
        return res;
    }
}
