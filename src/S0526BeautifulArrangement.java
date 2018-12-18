import java.util.Stack;

public class S0526BeautifulArrangement {
    private int count = 0;
    private boolean[] visited;
    private Stack<Integer> path;
    private int N;

    public int countArrangement(int N) {
        this.N = N;
        count = 0;
        path = new Stack<>();
        visited = new boolean[N];

        for (int i = 1; i <= N; i++) {
            dfs(i);
        }

        return count;
    }

    public void dfs(int i) {
        int p = path.size()+1;
        if (!(i%p == 0 || p%i == 0)) {
            return;
        }

        path.push(i);
        visited[i-1] = true;

        if (path.size() == N) {
            count++;
            path.pop();
            visited[i-1] = false;
            return;
        }

        for (int j = 1; j <= N; j++) {
            if (visited[j-1]) {
                continue;
            }
            dfs(j);
        }

        path.pop();
        visited[i-1] = false;
    }
}
