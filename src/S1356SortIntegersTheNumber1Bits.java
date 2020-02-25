import java.util.Arrays;

public class S1356SortIntegersTheNumber1Bits {
    public int[] sortByBits(int[] arr) {
        int[][] data = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            int c = 0;
            while (v != 0) {
                c += v%2;
                v = v/2;
            }
            data[i] = new int[]{c, arr[i]};
        }
        Arrays.sort(data, (o1, o2)-> {
            if (o1[0] != o2[0]) {
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = data[i][1];
        }
        return res;
    }
}
