import java.util.HashMap;
import java.util.HashSet;

public class S2227EncryptDecryptStrings {
    static class Encrypter {
        class Node {
            boolean isWord = false;
            Node[] children = new Node[26];
        }

        Node dict;
        HashMap<Character, String> enc;
        HashMap<Integer, HashSet<Character>> dec;

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            dict = new Node();
            enc = new HashMap<>();
            dec = new HashMap<>();
            for (String d : dictionary) {
                Node node = dict;
                for (char c : d.toCharArray()) {
                    if (node.children[c-'a'] == null) {
                        node.children[c-'a'] = new Node();
                    }
                    node = node.children[c-'a'];
                }
                node.isWord = true;
            }
            for (int i = 0; i < keys.length; i++) {
                enc.put(keys[i], values[i]);
                int v = 26*(values[i].charAt(0)-'a') + values[i].charAt(1)-'a';
                dec.putIfAbsent(v, new HashSet<>());
                dec.get(v).add(keys[i]);
            }
        }

        public String encrypt(String word1) {
            StringBuilder sb = new StringBuilder();
            for (char c : word1.toCharArray()) {
                sb.append(enc.get(c));
            }
            return sb.toString();
        }

        public int decrypt(String word2) {
            return dec(word2.toCharArray(), 0, dict);
        }

        private int dec(char[] ch, int p, Node node) {
            if (p == ch.length) {
                return node.isWord ? 1 : 0;
            }

            int v = 26*(ch[p]-'a')+(ch[p+1]-'a');
            if (!dec.containsKey(v)) {
                return 0;
            }
            int res = 0;
            for (char c : dec.get(v)) {
                if (node.children[c-'a'] == null) {
                    continue;
                }
                res += dec(ch, p+2, node.children[c-'a']);
            }
            return res;
        }
    }
}
