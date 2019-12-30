public class S1306JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, visited, start);
    }

    private boolean dfs(int[] arr, boolean[] visited, int index) {
        visited[index] = true;
        if (arr[index] == 0) {
            return true;
        }
        int l = index-arr[index], r = index+arr[index];
        if (l >= 0 && !visited[l]) {
            if (dfs(arr, visited, l)) {
                return true;
            }
        }
        if (r < arr.length && !visited[r]) {
            if (dfs(arr, visited, r)) {
                return true;
            }
        }

        visited[index] = false;
        return false;
    }
}
