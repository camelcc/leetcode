import java.util.Arrays;
import java.util.LinkedList;

public class S1574ShortestSubarrayRemovedMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        if(arr == null || arr.length <= 1) return 0;
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int i = 1, j;
        for (i = 1; i < len; i++){
            if(arr[i] >= arr[i-1])
                continue;
            break;
        }
        int ind1 = i-1;

        for (j = len-2; j >= 0; j--){
            if(arr[j] <= arr[j+1])
                continue;
            break;
        }
        int ind2 = j+1;
        if(ind2 < ind1) return 0;
        min = Math.min(ind2, arr.length-ind1-1);
        for (int k = 0; k <= ind1; k++){
            int ind = findNextGreater(arr, ind2, len-1, arr[k]);
            if(ind == -1)
                break;
            min = Math.min(min, (ind-1)  - (k+1) +1);
        }
        return min;
    }

    private int findNextGreater(int[] arr, int low , int high, int num){
        for (int i = low; i <= high; i++){
            if(arr[i] >= num)
                return i;
        }
        return -1;
    }
}
