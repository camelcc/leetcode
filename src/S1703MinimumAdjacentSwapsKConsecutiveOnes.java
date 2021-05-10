public class S1703MinimumAdjacentSwapsKConsecutiveOnes {
    public int minMoves(int[] nums, int k) {
        int len = nums.length;
        int cnt = 0;
        long min = Long.MAX_VALUE;
        for(int num : nums)
            if(num == 1)
                cnt++;
        int[] arr = new int[cnt];
        int idx = 0;
        long[] sum = new long[cnt+1];
        for(int i=0; i<len; i++)
            if(nums[i] == 1){
                arr[idx++] = i;
                sum[idx] = sum[idx-1]+i;
            }
        for(int i=0; i+k-1<cnt; i++)
            min = Math.min(min, getSum(arr, i, i+k-1, sum));
        return (int)min;
    }

    public long getSum(int[] arr, int l, int h, long[] sum){
        int mid = l+(h-l)/2;
        int k = h-l+1;
        int radius = mid-l;
        long res = sum[h+1]-sum[mid+1]-(sum[mid]-sum[l]) - (1+radius)*radius;
        if(k%2==0)
            res = res - arr[mid] - (radius+1);
        return res;
    }
}
