import java.util.*;

public class S0126WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        int resLen = 0;
        if (!wordList.contains(endWord)) {
            return res;
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        HashMap<String, List<String>> adjs = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            adjs.put(word, new ArrayList<>());
            for (int j = 0; j < i; j++) {
                String w = wordList.get(j);
                if (adjs(w, word)) {
                    adjs.get(w).add(word);
                    adjs.get(word).add(w);
                }
            }
        }

        HashSet<String> visited = new HashSet<>();
        List<List<String>> bfs = new ArrayList<>();
        List<String> t = new ArrayList<>();
        t.add(beginWord);
        bfs.add(t);
        while (!bfs.isEmpty()) {
            List<String> path = bfs.remove(0);
            assert path.size() > 0;
            String last = path.get(path.size()-1);
            visited.add(last);

            for (String word : adjs.get(last)) {
                if (visited.contains(word)) {
                    continue;
                }

                List<String> c = new ArrayList<>(path);
                c.add(word);
                if (word.equals(endWord)) {
                    if (res.isEmpty()) {
                        res.add(c);
                        resLen = c.size();
                    } else {
                        if (resLen == c.size()) {
                            res.add(c);
                        }
                    }
                } else {
                    if (resLen == 0 || resLen == c.size()+1) {
                        bfs.add(c);
                    }
                }
            }
        }
        return res;
    }

    private boolean adjs(String a, String b) {
        int d = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                d++;
            }
            if (d > 1) {
                break;
            }
        }
        return d == 1;
    }
}
