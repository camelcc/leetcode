// https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/discuss/1400597/Java-oror-LIS-oror-60ms-oror-beats-93-oror-T.C-O(nlogn)-S.C-O(n)
public class S1964FindLongestValidObstacleCourseEachPosition {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = 1, length = obstacles.length;
        int[] ans = new int[length], arr = new int[length];

        arr[0] = obstacles[0];
        ans[0] = 1;

        for (int i = 1; i < length; i++) {

            int val = obstacles[i];
            if (val >= arr[len - 1]) {
                arr[len++] = val;
                ans[i] = len;
            } else {
                int idx = binarySearch(arr, 0, len - 1, val);
                arr[idx] = val;
                ans[i] = idx + 1;
            }
        }

        return ans;
    }

    // O(logn) O(1)
    public int binarySearch(int[] arr, int lo, int hi, int val) {

        int ans = -1;
        while (lo <= hi) {

            int mid = (lo + hi) / 2;
            if (val >= arr[mid])
                lo = mid + 1;
            else {
                ans = mid;
                hi = mid - 1;
            }
        }

        return ans;
    }
}
