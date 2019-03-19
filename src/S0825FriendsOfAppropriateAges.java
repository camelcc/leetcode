import java.util.Arrays;

public class S0825FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for (int ai = 0; ai < ages.length; ai++) {
            int upper = ai;
            while (upper < ages.length && ages[upper] == ages[ai]) {
                upper++;
            }
            int minB = ages[ai]/2+7;
            int lower = Arrays.binarySearch(ages, 0, upper, minB);
            if (lower < 0) {
                lower = -(lower+1);
            }
            while (lower < ages.length && ages[lower] <= minB) {
                lower++;
            }
            if (lower >= upper) {
                continue;
            }
            res += upper - lower;
            if (ai >= lower && ai < upper) {
                res--;
            }
        }
        return res;
    }
}
