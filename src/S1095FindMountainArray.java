public class S1095FindMountainArray {
    interface MountainArray {
        public int get(int index);
        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int lo = 0, hi = mountainArr.length()-1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (mountainArr.get(mid) < mountainArr.get(mid+1)) {
                lo = mid+1;
            } else { // >
                hi = mid;
            }
        }
        int max = lo;
        if (mountainArr.get(max) == target) {
            return max;
        }
        lo = 0;
        hi = max-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (mountainArr.get(mid) < target) {
                lo = mid+1;
            } else if (mountainArr.get(mid) == target) {
                return mid;
            } else { // >
                hi = mid-1;
            }
        }

        lo = max+1;
        hi = mountainArr.length()-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (mountainArr.get(mid) < target) {
                hi = mid-1;
            } else if (mountainArr.get(mid) == target) {
                return mid;
            } else { // >
                lo = mid+1;
            }
        }
        return -1;
    }
}
