import java.util.Arrays;
import java.util.Random;

public class S0710RandomPickBlacklist {
    class Solution {
        private Random random;
        private int bounds;
        private int[] blacklist;

        public Solution(int N, int[] blacklist) {
            Arrays.sort(blacklist);
            this.blacklist = blacklist;
            random = new Random();
            bounds = N-blacklist.length;
        }

        public int pick() {
            int ri = random.nextInt(bounds);
            int p = Arrays.binarySearch(blacklist, ri);
            if (p < 0) {
                p = -(p+1);
            } else {
                p++;
            }

            int v = ri+p;
            while (p < blacklist.length && v >= blacklist[p]) {
                v++;
                p++;
            }
            return v;
        }
    }
}
