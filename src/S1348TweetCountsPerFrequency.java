import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class S1348TweetCountsPerFrequency {
    public static class TweetCounts {
        TreeMap<Integer, HashMap<String, Integer>> cnt;

        public TweetCounts() {
            cnt = new TreeMap<>();
        }

        public void recordTweet(String tweetName, int time) {
            cnt.putIfAbsent(time, new HashMap<>());
            HashMap<String, Integer> freq = cnt.get(time);
            freq.put(tweetName, freq.getOrDefault(tweetName, 0)+1);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            int inter = endTime;
            if (freq.equals("minute")) {
                inter = 60;
            } else if (freq.equals("hour")) {
                inter = 60*60;
            } else if (freq.equals("day")) {
                inter = 24*60*60;
            }

            List<Integer> res = new ArrayList<>();

            int i = 0;
            while (startTime+i*inter < endTime+1) {
                int c = 0;
                int begin = startTime+i*inter, end = Math.min(begin+inter, endTime+1);
                Integer time = cnt.ceilingKey(begin);
                while (time != null && time < end) {
                    c += cnt.get(time).getOrDefault(tweetName, 0);
                    time = cnt.higherKey(time);
                }

                res.add(c);
                i++;
            }
            return res;
        }
    }
}
