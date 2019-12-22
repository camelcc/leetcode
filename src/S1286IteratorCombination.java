public class S1286IteratorCombination {
    static class CombinationIterator {
        String characters;
        String next;

        public CombinationIterator(String characters, int combinationLength) {
            this.characters = characters;
            next = characters.substring(0, combinationLength);
        }

        public String next() {
            String res = next;

            int p = next.length()-1;
            while (p >= 0) {
                int pos = characters.indexOf(next.charAt(p));
                if (pos+1+next.length()-p <= characters.length()) {
                    next = next.substring(0, p) + characters.substring(pos+1, pos+1+next.length()-p);
                    break;
                } else {
                    p--;
                }
            }
            if (p < 0) {
                next = null;
            }

            return res;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
