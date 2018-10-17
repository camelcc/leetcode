public class S0744FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length-1;
        if (target >= letters[letters.length-1] || target < letters[0]) {
            return letters[0];
        }

        // target >= lo, target < hi
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            char c = letters[mid];
            if (c < target) {
                lo = mid+1;
            } else if (c == target) {
                lo = mid+1;
            } else { // c > target
                hi = mid;
            }
        }
        return letters[lo];
    }
}
