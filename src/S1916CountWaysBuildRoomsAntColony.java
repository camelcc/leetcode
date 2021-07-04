import java.math.BigInteger;
import java.util.ArrayList;

// https://leetcode.com/problems/count-ways-to-build-rooms-in-an-ant-colony/discuss/1300738/Concise-Java-solution-using-BigInteger
public class S1916CountWaysBuildRoomsAntColony {
    int mod=1000000007;
    public int waysToBuildRooms(int[] prevRoom) {
        int n=prevRoom.length;
        ArrayList<Integer>[] tree= new ArrayList[n];
        for(int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            tree[prevRoom[i]].add(i);
        }
        int size[]=new int[n];
        dfs(tree,size,0);
        long fact=1;
        for(int i=1;i<=n;i++){
            fact=(fact*i)%mod;
        }
        long denomin=1;
        for(int i=0;i<n;i++){
            denomin=(denomin*size[i])%mod;
        }
        BigInteger den=BigInteger.valueOf(denomin);
        den=den.modInverse(BigInteger.valueOf(mod));
        return (int)((fact*den.longValue())%mod);

    }
    int dfs(ArrayList<Integer>[] tree, int[] size, int root ){
        int ans=1;
        for(int e:tree[root]){
            ans+=dfs(tree,size,e);
        }
        size[root]=ans;
        return ans;
    }
}
