import java.util.*;

// https://leetcode.com/problems/longest-common-subpath/discuss/1317530/JAVA-Rolling-HASH-with-detail-comment-(forgive-me-for-poor-english)

/**
 * Thank you for read my topic, plz forgive me for my poor English.
 * At the beginning, I try to add a hash collision check but it's too slow during test case 68.
 * Then, I remove the collision check. But test case 70 makes me crazy (you have to choice the mod and base value carefully to avoid hash collision during that case)
 * Finally, I use a track: calculate the hash value for a string in two ways to reduce the probability of hash collision. And it works.
 */
public class S1923LongestCommonSubpath {
    /**
     * choice two prime numbers(use prime numbers because: 1.reduce the probability of hash collision  2.the inverse element can be calculate easily base on the Euler's Theorem)
     * remark:
     * 1. The inverse element of 'base' on a module p finite field means a number x that satisfies (x*base) mod p = 1
     * 2. According to the Euler's Theorem, we can know (base^(p-1)) mod p = 1, so base^(p-2) mod p is the inverse element of 'base'
     */
    private long[] p = {100000007,100000037};
    public int longestCommonSubpath(int n, int[][] paths) {
        long base=n;
        long[] inverse = calculateInverse(base);
        Arrays.sort(paths,(a, b)->a.length-b.length);
        int min=0;
        //Obviously: 1. ans<=min(paths[i])  2. If exists a common subpath with length L, a common subpath with length N (for any N<=L) will always exist.
        //So we can use binary search
        int max=paths[0].length;
        while (min<max){
            int mid=(min+max+1)/2;
            if(judge(paths,mid,base,inverse)){
                min=mid;
            }else {
                max=mid-1;
            }
        }
        return min;
    }

    /**
     * calculate the inverse element of 'base' for each p. In other words: base^(p-2) mod p
     * To calculate fast, we can express p-2 as a binary string.
     * Assume p-2 can be represented as 11011 then base^(p-2) = base^(2^4+2^3+2^1+2^0) = base^16 * base^8 * base^2 * base^1
     */
    private long[] calculateInverse(long base) {
        return Arrays
                .stream(p)
                .map(eachP -> {
                    long temp = base;
                    long inverse = 1;
                    for (char c : new StringBuilder(Long.toBinaryString(eachP - 2)).reverse().toString().toCharArray()) {
                        if (c == '1') {
                            inverse *= temp;
                            inverse %= eachP;
                        }
                        temp *= temp;
                        temp %= eachP;
                    }
                    return inverse;
                })
                .toArray();
    }

    /**
     * check whether there exists a common path with certain length
     */
    private boolean judge(int[][] paths, int commonPathLength, long base, long[] baseInverse) {
        //The key stores the first hash and the value stores the second hash. (If the size of value is bigger than one that means there is a hash collision)
        //By this way we can reduce the probability of hash collision
        Map<Long, Set<Long>> samePathHash = new HashMap<>();
        //To distinguish the first path
        boolean isFirst = true;
        for(int[] path:paths){
            //hash[0]=(str[0]-'a') + (str[1]-'a')* base + ... +(str[n]-'a') * base^n  mod p[0]
            //hash[1]=(str[0]-'a') + (str[1]-'a')* base + ... +(str[n]-'a') * base^n  mod p[1]
            long[] curHash=new long[2];
            long[] curBase=new long[]{1,1};
            for(int i=0;i<commonPathLength-1;i++){
                for(int j=0;j<=1;j++){
                    curHash[j]+=(curBase[j]*(path[i]));
                    curHash[j]%= p[j];
                    curBase[j]*=base;
                    curBase[j]%= p[j];
                }
            }

            Map<Long,Set<Long>> temp = new HashMap<>();
            for(int i=commonPathLength-1;i<path.length;i++){
                for(int j=0;j<=1;j++) {
                    curHash[j] += (curBase[j] * (path[i]));
                    curHash[j] %= p[j];
                }

                if(isFirst) {
                    samePathHash.computeIfAbsent(curHash[0],key->new HashSet<>()).add(curHash[1]);
                }else {
                    if(samePathHash.getOrDefault(curHash[0], Collections.emptySet()).contains(curHash[1])){
                        temp.computeIfAbsent(curHash[0],key->new HashSet<>()).add(curHash[1]);
                    }
                }
                for (int j = 0; j <= 1; j++) {
                    curHash[j] -= path[i - commonPathLength + 1];
                    curHash[j] *= baseInverse[j];
                    curHash[j] %= p[j];
                }
            }
            if(isFirst){
                isFirst=false;
            }else {
                if(temp.isEmpty()){
                    return false;
                }
                samePathHash=temp;
            }
        }
        return true;
    }
}
