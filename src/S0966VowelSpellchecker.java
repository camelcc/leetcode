import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class S0966VowelSpellchecker {
    private class Trie {
        Trie[] children;
        HashSet<Integer> index;

        public Trie() {
            children = new Trie[26];
            index = new HashSet<>();
        }
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Trie root = new Trie();
        for (int i = 0; i < wordlist.length; i++) {
            String w = wordlist[i].toLowerCase();
            Trie n = root;
            for (int j = 0; j < w.length(); j++) {
                boolean last = j == w.length()-1;
                char c = w.charAt(j);
                if (n.children[c-'a'] == null) {
                    n.children[c-'a'] = new Trie();
                }
                n = n.children[c-'a'];
                if (last) {
                    n.index.add(i);
                }
            }
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String w = queries[i].toLowerCase();
            List<Trie> matches = new ArrayList<>();
            matches.add(root);
            for (int j = 0; j < w.length(); j++) {
                char c = w.charAt(j);
                List<Trie> next = new ArrayList<>();
                for (Trie m : matches) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        if (m.children['a'-'a'] != null) {
                            next.add(m.children['a'-'a']);
                        }
                        if (m.children['e'-'a'] != null) {
                            next.add(m.children['e'-'a']);
                        }
                        if (m.children['i'-'a'] != null) {
                            next.add(m.children['i'-'a']);
                        }
                        if (m.children['o'-'a'] != null) {
                            next.add(m.children['o'-'a']);
                        }
                        if (m.children['u'-'a'] != null) {
                            next.add(m.children['u'-'a']);
                        }
                    } else {
                        if (m.children[c-'a'] != null) {
                            next.add(m.children[c-'a']);
                        }
                    }
                }
                matches = next;
            }
            List<Integer> indices = new ArrayList<>();
            for (Trie m : matches) {
                indices.addAll(m.index);
            }
            Collections.sort(indices);
            if (matches.isEmpty()) {
                res[i] = "";
                continue;
            }
            int exact = -1, upper = -1;
            for (int m : indices) {
                if (queries[i].equals(wordlist[m])) {
                    exact = m;
                    break;
                }
                if (queries[i].toLowerCase().equals(wordlist[m].toLowerCase())) {
                    if (upper == -1) {
                        upper = m;
                    }
                }
            }
            if (exact != -1) {
                res[i] = wordlist[exact];
            } else if (upper != -1) {
                res[i] = wordlist[upper];
            } else {
                res[i] = wordlist[indices.get(0)];
            }
        }
        return res;
    }
}
