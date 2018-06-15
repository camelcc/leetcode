import java.util.Arrays;

public class S0475Heaters {
    public int findRadius(int[] houses, int[] heaters) {
//        insertSort(houses);
//        insertSort(heaters);
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int lo = 0;
        int radius = 0;

        for (int i = 0; i < houses.length; i++) {
            lo = nearnestHeader(heaters, lo, heaters.length-1, houses[i]);

            int r = 0;
            if (lo < heaters.length - 1) {
                r = Math.min(Math.abs(heaters[lo] - houses[i]), Math.abs(heaters[lo + 1] - houses[i]));
            } else {
                r = Math.abs(heaters[lo] - houses[i]);
            }

            if (r > radius) {
                radius = r;
            }
        }

        return radius;
    }

    private int nearnestHeader(int[] heaters, int lo, int hi, int house)  {
        while (lo < hi) {
            int mid = (lo + hi)/2;
            if (heaters[mid] < house) {
                lo = mid+1;
            } else if (heaters[mid] > house) {
                hi = mid-1;
            } else {
                lo = mid;
                break;
            }
        }
        if (lo > 0 && heaters[lo] > house) {
            lo--;
        }
        return lo;
    }

    private void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j-1]) {
                    int t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;
                } else {
                    break;
                }
            }
        }
    }
}
