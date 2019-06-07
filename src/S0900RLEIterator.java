public class S0900RLEIterator {
    class RLEIterator {
        private int[] a;
        private int pos;

        public RLEIterator(int[] A) {
            this.a = A;
            this.pos = 0;
        }

        public int next(int n) {
            assert pos%2 == 0;
            if (pos >= a.length) {
                return -1;
            }
            if (a[pos] == 0) {
                pos += 2;
                return next(n);
            }

            if (a[pos] >= n) {
                a[pos] -= n;
                return a[pos+1];
            }
            n -= a[pos];
            pos += 2;
            return next(n);
        }
    }
}
