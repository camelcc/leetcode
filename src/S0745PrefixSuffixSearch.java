public class S0745PrefixSuffixSearch {
    public static class WordFilter {
        private class Tire {
            int weight;
            char c;
            Tire[] children;

            public Tire() {
                children = new Tire[27];
                weight = 0;
            }
        }

        private Tire root;

        public WordFilter(String[] words) {
            root = new Tire();
            root.c = '\0';
            for (int i = 0; i < words.length; i++) {
                String post = "{"+words[i];
                for (int j = 0; j <= words[i].length(); j++) {
                    String w = words[i].substring(j)+post;
                    Tire cur = root;
                    cur.weight = i;

                    for (char c : w.toCharArray()) {
                        if (cur.children[c-'a'] == null) {
                            cur.children[c-'a'] = new Tire();
                            cur.c = c;
                        }
                        cur = cur.children[c-'a'];
                        cur.weight = i;
                    }
                }
            }
        }

        public int f(String prefix, String suffix) {
            Tire n = root;
            for (char c : (suffix+"{"+prefix).toCharArray()) {
                if (n.children[c-'a'] == null) {
                    return -1;
                }
                n = n.children[c-'a'];
            }
            return n.weight;
        }
    }
}
