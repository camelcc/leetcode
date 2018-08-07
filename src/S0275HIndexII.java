public class S0275HIndexII {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int lo = 0, hi = citations.length-1;
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            int h = citations.length - mid;

            if (lo == hi) {
                if (h <= citations[mid]) {
                    return h;
                } else {
                    return 0;
                }
            }

            if (h > citations[mid]) {
                lo = mid+1;
            } else if (h == citations[mid]) {
                return h;
            } else {
                hi = mid;
            }
        }
        return 0;
    }
}
