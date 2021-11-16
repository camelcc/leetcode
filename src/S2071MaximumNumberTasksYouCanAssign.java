import java.util.Arrays;
import java.util.TreeMap;

//https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/discuss/1575983/Java-BinarySearch-%2B-TreeMap-Greedy
public class S2071MaximumNumberTasksYouCanAssign {
    public int maxTaskAssign(int[] A, int[] B, int cnt, int add) {
        Arrays.sort(A);
        Arrays.sort(B);
        int l = 0, r = A.length-1;
        int res = -1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(check(A,B,cnt,add,mid)){
                res=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return res+1;
    }

    public boolean check(int A[],int B[],int cnt,int add,int mid){
        TreeMap<Integer,Integer> tree=new TreeMap<>();
        int j = B.length-1;

        for(int i = mid; i >=0; i--){
            while(j>=0&&B[j]>=A[i]){
                add(tree,B[j]);
                j--;
            }

            Integer ceil = tree.ceilingKey(A[i]);
            if(ceil!=null){
                del(tree,ceil);
            }
            else{
                if(cnt>0){
                    while(j>=0&&B[j]+add>=A[i]){
                        add(tree,B[j]);
                        j--;
                    }

                    ceil = tree.ceilingKey(A[i]-add);
                    if(ceil!=null){
                        cnt--;
                        del(tree,ceil);
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }

            }
        }
        return true;
    }

    public void add(TreeMap<Integer,Integer>tree,int k){
        if(!tree.containsKey(k))tree.put(k,0);
        tree.put(k,tree.get(k)+1);
    }

    public void del(TreeMap<Integer,Integer>tree,int k){
        tree.put(k,tree.get(k)-1);
        if(tree.get(k)==0)tree.remove(k);
    }
}
