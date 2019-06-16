public class S0458PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest/minutesToDie + 1;
        return (int)Math.ceil(Math.log(buckets)/Math.log(times));
    }
}
