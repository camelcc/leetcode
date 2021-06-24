import java.util.LinkedList;

public class S1905CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count=0;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1 && visited[i][j]==false){
                    if(dfs(grid1,grid2,i,j,visited)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid1, int[][] grid2,int i,int j,boolean[][] visited){
        if(i<0 || j<0 || i>=grid1.length || j>=grid1[0].length || grid2[i][j]==0 || visited[i][j]==true ){
            return true;
        }
        if(grid2[i][j]!=grid1[i][j]) return false;
        visited[i][j]=true;
        boolean a=dfs(grid1,grid2,i-1,j,visited);
        boolean b=dfs(grid1,grid2,i,j-1,visited);
        boolean c=dfs(grid1,grid2,i+1,j,visited);
        boolean d=dfs(grid1,grid2,i,j+1,visited);
        return a&&b&&c&&d;
    }
}
