import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-operations-to-make-the-array-k-increasing/discuss/1635375/Java-%2B-Intuition-%2B-LIS-%2B-Binary-Search
public class S2111MinimumOperationsMakeArrayKIncreasing {
    public int kIncreasing(int[] arr, int k) {
        int total = 0;
        for(int i=0; i < k; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=i; j < arr.length; j = j+k)
                list.add(arr[j]);
            total += list.size() - lengthOfLIS(list);
        }
        return total;
    }

    // Get the length of LIS by building an increasing List so as to perform binary search on it
    // in case the current element is lesser than the last element in the increasing List.
    // In such case we get the next greater element from the increasing List by doing a binary Search and
    // replace that with the the current element in the increasing List, as the other element is no longer relevant in participating in LIS.
    // The increasing List remains sorted and always maintain the max length of the increasing subsequence.
    public int lengthOfLIS(List<Integer> nums){
        List<Integer> incrList = new ArrayList<>();
        incrList.add(nums.get(0));

        for(int i=1; i < nums.size(); i++){
            int lastItem = incrList.get(incrList.size()-1);
            if(nums.get(i) >= lastItem){
                incrList.add(nums.get(i));
            } else {
                int idx = nextGreaterItem(incrList, nums.get(i));
                incrList.set(idx, nums.get(i));
            }
        }
        return incrList.size();
    }

    // Perform Binary Search to get the next greater element
    int nextGreaterItem(List<Integer> list, int num){
        int left = 0, right = list.size()-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(num >= list.get(mid))
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
