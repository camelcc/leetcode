import java.util.HashMap;

public class S0833FindAndReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        HashMap<String, String>[] maps = new HashMap[S.length()];
        for (int i = 0; i < indexes.length; i++) {
            int p = indexes[i];
            if (maps[p] == null) {
                maps[p] = new HashMap<>();
            }
            maps[p].put(sources[i], targets[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            boolean matched = false;
            if (maps[i] != null) {
                for (String src : maps[i].keySet()) {
                    if (S.startsWith(src, i)) {
                        sb.append(maps[i].get(src));
                        i = i + src.length()-1;
                        matched = true;
                        break;
                    }
                }
            }
            if (!matched) {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }
}
