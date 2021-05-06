import java.util.Arrays;
import java.util.Comparator;

public class S1691MaximumHeightStackingCuboids {
    public int maxHeight(int[][] cuboids) {
        // height will be maximum of length,breadth and height.
        for(int [] box : cuboids)
            Arrays.sort(box);
        // sort cuboids in increasing order of their heights.
        // if same heigth sort them in increasing order of their breadth.
        // if even breadth is also same, sort them in increasing order of their height.
        Arrays.sort(cuboids,new Comparator<>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[2]!=b[2])return a[2] - b[2];
                if(a[1]!=b[1])return a[1]-b[1];
                return a[0] - b[0];
            }
        });
        int n = cuboids.length;
        int[] dp = new int[n];
        int maxH = 0;
        for(int i=0;i<n;i++){
            dp[i] = cuboids[i][2];
            for(int j=0;j<i;j++)
                if(cuboids[i][0]>=cuboids[j][0] && cuboids[i][1]>=cuboids[j][1] && cuboids[i][2]>=cuboids[j][2] )
                    dp[i] = Math.max(dp[i],cuboids[i][2] + dp[j]);
            maxH = Math.max(maxH,dp[i]);
        }
        return maxH;
    }
}
