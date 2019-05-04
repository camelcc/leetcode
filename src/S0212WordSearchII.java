import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S0212WordSearchII {
    public static class Tire {
        String str;
        boolean word;
        Tire[] children;

        public Tire(String pre, char c) {
            this.str = pre + c;
            word = false;
            children = new Tire[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> res = new HashSet<>();
        if (board.length == 0 || board[0].length == 0) {
            return new ArrayList<>(res);
        }

        Tire root = new Tire("", '\0');
        root.str = "";
        for (String word : words) {
            Tire node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c-'a'] == null) {
                    node.children[c-'a'] = new Tire(node.str, c);
                }
                node = node.children[c-'a'];
                if (i == word.length()-1) {
                    node.word = true;
                }
            }
        }

        int M = board.length, N = board[0].length;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                Tire n = root.children[board[r][c]-'a'];
                if (n == null) {
                    continue;
                }

                boolean[][] visited = new boolean[M][N];
                res.addAll(paths(root.children[board[r][c]-'a'], board, visited, r, c));
            }
        }

        return new ArrayList<>(res);
    }

    private HashSet<String> paths(Tire node, char[][] board, boolean[][] visited, int r, int c) {
        HashSet<String> res = new HashSet<>();
        visited[r][c] = true;
        if (node.word) {
            res.add(node.str);
        }

        if (c > 0 && !visited[r][c-1] && node.children[board[r][c-1]-'a'] != null) {
            res.addAll(paths(node.children[board[r][c-1]-'a'], board, visited, r, c-1));
        }
        if (r > 0 && !visited[r-1][c] && node.children[board[r-1][c]-'a'] != null) {
            res.addAll(paths(node.children[board[r-1][c]-'a'], board, visited, r-1, c));
        }
        if (r < board.length-1 && !visited[r+1][c] & node.children[board[r+1][c]-'a'] != null) {
            res.addAll(paths(node.children[board[r+1][c]-'a'], board, visited, r+1, c));
        }
        if (c < board[0].length-1 && !visited[r][c+1] && node.children[board[r][c+1]-'a'] != null) {
            res.addAll(paths(node.children[board[r][c+1]-'a'], board, visited, r, c+1));
        }

        visited[r][c] = false;
        return res;
    }
}
