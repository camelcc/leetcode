import java.util.Random;

public class S0470ImplementRand10UsingRand7 {
    private class SolBase {
        public int rand7() {
            return new Random().nextInt(7);
        }
    }

    class Solution extends SolBase {
        public int rand10() {
            int result = 40;
            while (result >= 40) {result = 7 * (rand7() - 1) + (rand7() - 1);}
            return result % 10 + 1;
        }
    }
}
