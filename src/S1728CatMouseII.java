import java.util.HashSet;
import java.util.LinkedList;

public class S1728CatMouseII {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    Boolean[][][][][] cache;
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int rows = grid.length;
        int cols = grid[0].length();
        char[][] matrix = new char[rows][cols];
        cache = new Boolean[rows][cols][rows][cols][rows*cols*2];
        int[] cpos = null;
        int[] mpos = null;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                char c = grid[i].charAt(j);
                matrix[i][j] = c;
                if(c == 'M')
                    mpos = new int[]{i, j};
                if(c == 'C')
                    cpos = new int[]{i, j};
            }
        }
        return helper(mpos, cpos, matrix, catJump, mouseJump, 0);
    }
    public boolean helper(int[] mpos, int[] cpos, char[][] matrix, int cmax, int mmax, int steps){
        if(steps == matrix[0].length*matrix.length*2) return false;
        if(cache[mpos[0]][mpos[1]][cpos[0]][cpos[1]][steps] != null)
            return cache[mpos[0]][mpos[1]][cpos[0]][cpos[1]][steps];
        if(mpos[0]==cpos[0] && mpos[1]==cpos[1]) return false;
        if(matrix[cpos[0]][cpos[1]]=='F') return false;
        if(matrix[mpos[0]][mpos[1]]=='F') return true;
        int[] nextmpos = new int[]{mpos[0], mpos[1]};
        int[] nextcpos = new int[]{cpos[0], cpos[1]};
        if(steps%2 == 0){
            for(int[] dir : dirs){
                for (int jump = 0; jump <= mmax; jump++) {
                    nextmpos[0] = mpos[0] + dir[0] * jump;
                    nextmpos[1] = mpos[1] + dir[1] * jump;
                    if (nextmpos[0]<0 || nextmpos[0]>=matrix.length || nextmpos[1]<0 || nextmpos[1]>=matrix[0].length || matrix[nextmpos[0]][nextmpos[1]] == '#') break;
                    if (helper(nextmpos, cpos, matrix, cmax, mmax, steps + 1))
                        return cache[mpos[0]][mpos[1]][cpos[0]][cpos[1]][steps] = true;
                }
            }
            return cache[mpos[0]][mpos[1]][cpos[0]][cpos[1]][steps] = false;
        }else{
            for(int[] dir : dirs){
                for (int jump = 0; jump <= cmax; jump++) {
                    nextcpos[0] = cpos[0] + dir[0] * jump;
                    nextcpos[1] = cpos[1] + dir[1] * jump;
                    if (nextcpos[0]<0 || nextcpos[0]>=matrix.length || nextcpos[1]<0 || nextcpos[1]>=matrix[0].length || matrix[nextcpos[0]][nextcpos[1]] == '#') break;
                    if (!helper(mpos, nextcpos, matrix, cmax, mmax, steps + 1))
                        return cache[mpos[0]][mpos[1]][cpos[0]][cpos[1]][steps] = false;
                }
            }
            return cache[mpos[0]][mpos[1]][cpos[0]][cpos[1]][steps] = true;
        }
    }
}
