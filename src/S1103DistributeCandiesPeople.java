public class S1103DistributeCandiesPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int p = 0, remains = candies, seq = 1;
        while (remains > 0) {
            res[p] += Math.min(remains, seq);
            remains -= seq;
            seq++;
            p = (p+1)%num_people;
        }
        return res;
    }
}
