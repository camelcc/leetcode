import java.util.Arrays;

public class S0881BoatsSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] onBoat = new boolean[people.length];
        int res = 0;
        for (int i = people.length-1; i >= 0; i--) {
            if (onBoat[i]) {
                continue;
            }
            onBoat[i] = true;
            res++;

            int remains = limit - people[i];
            int p = Arrays.binarySearch(people, remains);
            if (p < 0) {
                p = -(p+1);
                p--;
            } else {
                while (p < people.length-1 && people[p] == people[p+1]) {
                    p++;
                }
            }
            while (p >= 0) {
                if (!onBoat[p]) {
                    onBoat[p] = true;
                    break;
                }
                p--;
            }
        }
        return res;
    }
}
