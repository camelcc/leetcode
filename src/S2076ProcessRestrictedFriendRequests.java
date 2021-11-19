// https://leetcode.com/problems/process-restricted-friend-requests/discuss/1585292/Java-Union-Find-with-Adjustment-for-Restrictions-and-Comments
public class S2076ProcessRestrictedFriendRequests {
    private int[] parents;
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        parents = new int[n];
        // initially, each friend is their own parent (i.e no two people are friends)
        for(int i = 1; i < n; i ++)
            parents[i] = i;
        boolean[] res = new boolean[requests.length];
        for(int i = 0; i < requests.length; i ++) {
            boolean flag = true;
            // find the parent of 2 people who want to become friends
            int par1 = find(requests[i][0]), par2 = find(requests[i][1]);

            // loop through restrictions list to account for restrictions
            for(int j = 0; j < restrictions.length; j ++) {
                // for each person in a restrictions pair, find a parent of each person
                int par_1 = find(restrictions[j][0]), par_2 = find(restrictions[j][1]);

                // if parents of the current restriction tuple are identical to the parents of 2 people trying to become friends,
                // then satisfying the friend request will result in the condition where two people from the current restriction tuple
                // will be present in the same connected component (i.e. they will be direct or indirect friends, which violates the condition).
                // So we must not join the two people who are trying to become friends
                if(par1 == par_1 && par2 == par_2 || par1 == par_2 && par2 == par_1) {
                    flag = false;
                    break;
                }
            }
            res[i] = flag;
            // only satisfy those friend requests that do not violate the given condition
            if(flag) {
                parents[par2] = par1;
            }
        }
        return res;
    }

    public int find(int i) {
        if(parents[i] == i) return i;
        return parents[i] = find(parents[i]);
    }
}
