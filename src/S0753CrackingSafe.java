import java.util.Arrays;
import java.util.HashSet;

public class S0753CrackingSafe {
    public String crackSafe(int n, int k) {
        char[] start = new char[n];
        Arrays.fill(start, '0');
        StringBuilder res = new StringBuilder();
        res.append(String.valueOf(start));
        HashSet<String> visited = new HashSet<>();
        visited.add(String.valueOf(start));
        int total = (int)Math.pow(k, n);
        dfs(res, visited, total, n, k);
        return res.toString();
    }

    private boolean dfs(StringBuilder sb, HashSet<String> visited, int total, int n, int k) {
        if (visited.size() == total) {
            return true;
        }

        String current = sb.substring(sb.length()-n);
        for (int i = 0; i < k; i++) {
            char c = (char) ('0' + i);
            String next = current.substring(1)+c;
            if (visited.contains(next)) {
                continue;
            }

            visited.add(next);
            sb.append(c);
            if (dfs(sb, visited, total, n, k)) {
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
            visited.remove(next);
        }

        return false;
    }
}
