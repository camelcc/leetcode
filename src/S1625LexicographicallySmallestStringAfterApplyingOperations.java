import java.util.HashSet;

public class S1625LexicographicallySmallestStringAfterApplyingOperations {
    String res;

    public String findLexSmallestString(String s, int a, int b) {
        res = s;
        dfs(s, a, b, new HashSet<>());
        return res;
    }

    private void dfs(String s, int a, int b, HashSet<String> visited) {
        if (s.compareTo(res) < 0) {
            res = s;
        }
        visited.add(s);
        // add
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i%2 == 0) {
                sb.append(c);
            } else {
                sb.append((char)('0' + (c-'0'+a)%10));
            }
        }
        String add = sb.toString();
        if (!visited.contains(add)) {
            dfs(add, a, b, visited);
        }
        // rotate
        String rotate = s.substring(s.length()-b) + s.substring(0, s.length()-b);
        if (!visited.contains(rotate)) {
            dfs(rotate, a, b, visited);
        }
    }
}
