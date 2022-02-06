public class S2166DesignBitset {
    static class Bitset {
        int size;
        int[] bits;
        int ones;

        public Bitset(int size) {
            this.size = size;
            this.bits = new int[(size+31)/32];
            this.ones = 0;
        }

        public void fix(int idx) {
            int i = idx/32, j = idx%32;
            if ((bits[i] & (0x1<<j)) == 0) {
                ones++;
                bits[i] = bits[i] | (0x1<<j);
            }
        }

        public void unfix(int idx) {
            int i = idx/32, j = idx%32;
            if ((bits[i] & (0x1<<j)) != 0) {
                ones--;
                bits[i] = bits[i] ^ (0x1<<j);
            }
        }

        public void flip() {
            for (int i = 0; i < bits.length; i++) {
                bits[i] = ~bits[i];
            }
            ones = size-ones;
        }

        public boolean all() {
            return ones == size;
        }

        public boolean one() {
            return ones > 0;
        }

        public int count() {
            return ones;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int b : bits) {
                for (int i = 0; i < 32; i++) {
                    sb.append((b & (0x1<<i)) != 0 ? '1' : '0');
                }
            }
            String r = sb.toString();
            return r.substring(0, size);
        }
    }
}
