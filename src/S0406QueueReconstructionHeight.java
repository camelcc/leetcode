import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class S0406QueueReconstructionHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        List<int[]> queue = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int taller = 0;
            int j = 0;
            while (j < queue.size()) {
                if (queue.get(j)[0] >= people[i][0]) {
                    taller++;
                }
                if (taller > people[i][1]) {
                    break;
                }
                j++;
            }
            queue.add(j, people[i]);
        }
        return queue.toArray(new int[people.length][2]);
    }
}
