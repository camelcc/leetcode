import java.util.Arrays;
import java.util.Comparator;

public class S0720LongestWordDictionary {
    private class Trie {
        boolean valid;
        Trie[] children;

        public Trie(boolean valid) {
            this.valid = valid;
            children = new Trie[26];
        }
    }

    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o2.length()-o1.length();
                }
            }
        });

        Trie root = new Trie(false);
        for (String w : words) {
            Trie node = root;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (node.children[c-'a'] == null) {
                    node.children[c-'a'] = new Trie(i == (w.length()-1));
                }
                if (i == w.length()-1) {
                    node.children[c-'a'].valid = true;
                }
                node = node.children[c-'a'];
            }
        }

        for (String w : words) {
            Trie node = root;
            boolean valid = true;
            for (int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                if (node.children[c-'a'] == null || !node.children[c-'a'].valid) {
                    valid = false;
                    break;
                }
                node = node.children[c-'a'];
            }
            if (valid) {
                return w;
            }
        }
        return "";
    }
}
