// https://leetcode.com/problems/minimum-distance-to-the-target-element/discuss/1246772/java-100-better-time-solution
public class S1848MinimumDistanceTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        if(nums[start] == target) return 0;
        int i = start-1, j = start+1;
        while(i >= 0 && j < nums.length) {
            if(nums[i] == target) return start - i;
            if(nums[j] == target) return j - start;
            i--;
            j++;
        }
        while(i >= 0) {
            if(nums[i] == target) return start - i;
            i--;
        }
        while(j < nums.length) {
            if(nums[j] == target) return j - start;
            j++;
        }
        return 0;
    }
}
