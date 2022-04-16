public class S2241DesignATMMachine {
    class ATM {
        private long[] cnt;
        private int[] value;

        public ATM() {
            value = new int[]{20, 50, 100, 200, 500};
            cnt = new long[5];
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < banknotesCount.length; i++) {
                cnt[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] res = new int[5];
            int p = 4;
            while (amount > 0 && p >= 0) {
                // value[p] <= amount
                res[p] = (int)Math.min((long)amount/value[p], cnt[p]);
                amount -= res[p] * value[p];
                p--;
            }
            if (amount != 0) {
                return new int[]{-1};
            }
            for (int i = 0; i < 5; i++) {
                cnt[i] -= res[i];
            }
            return res;
        }
    }
}
