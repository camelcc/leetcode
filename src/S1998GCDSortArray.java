import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/gcd-sort-of-an-array/discuss/1450794/Java-Explanation-Tricky-Group-w-Smallest-Prime-Factor
public class S1998GCDSortArray {
    Map<Integer, Integer> parent;
    public boolean gcdSort(int[] nums) {
        /**
         general idea (not accepted)
         we can simply union pairs of numbers which has gcd > 1 in quadratic time and then check of groups that
         are formed by union of pairs can be invidually sorted.


         improved (accpeted)
         In above approach problem is we are union-ing pairs in quadratic time. To improve upon it. We union a number
         which is present in 'nums' with its smallest prime factor. thus if two numbers has same smallest prime factor
         their gcd is guaranted to be >1.
         **/

        /* create parent map */
        parent = new HashMap<Integer, Integer>();

        /* create a clone of 'nums' and sort it. */
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        /* find the max of arr, so that we can union numbers upto max with smallest prime factors. */
        int max = Integer.MIN_VALUE;
        for(int val : nums) max = Math.max(max, val);

        // create a set of numbers so that loop up to see if number is present is O(1)
        Set<Integer> numSet = new HashSet<Integer>();
        for(int val : nums) numSet.add(val);

        // seive
        int p = 2;
        boolean[] primes = new boolean[max+1];
        Arrays.fill(primes, true);
        while(p<=max){
            if(primes[p]){
                for(int i=p; i<=max; i+=p){
                    if(numSet.contains(i)) union(p, i);
                    primes[i]= false;
                }
            }
            p++;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]!=sortedNums[i] && find(nums[i])!=find(sortedNums[i]))
                return false;
        }
        return true;

    }
    public int find(int x){
        if(!parent.containsKey(x)){
            parent.put(x, x);
            return x;
        }
        if(x!=parent.get(x))
            parent.put(x,find(parent.get(x)));
        return parent.get(x);
    }
    public void union(int x, int y){
        int lx = find(x), ly = find(y);

        if(lx!=ly){
            parent.put(lx, ly);
        }
    }
}
