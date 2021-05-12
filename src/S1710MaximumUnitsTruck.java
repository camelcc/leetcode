import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class S1710MaximumUnitsTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt((ToIntFunction<int[]>) value -> value[1]).reversed());
        int res = 0, i = 0;
        while (truckSize > 0 && i < boxTypes.length) {
            res = res + Math.min(truckSize, boxTypes[i][0]) * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
            i++;
        }
        return res;
    }
}
