import java.util.*;

public class S1311GetWatchedVideosYourFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        boolean[] visited = new boolean[friends.length];
        List<Integer> people = new ArrayList<>();
        people.add(id);
        visited[id] = true;

        while (level > 0) {
            List<Integer> next = new ArrayList<>();
            for (int f : people) {
                for (int n : friends[f]) {
                    if (!visited[n]) {
                        visited[n] = true;
                        next.add(n);
                    }
                }
            }
            people = next;
            level--;
        }

        HashMap<String, Integer> freq = new HashMap<>();
        for (int p : people) {
            for (String v : watchedVideos.get(p)) {
                freq.put(v, freq.getOrDefault(v, 0)+1);
            }
        }


        PriorityQueue<String> video = new PriorityQueue<>((o1, o2) -> {
            int f1 = freq.getOrDefault(o1, 0);
            int f2 = freq.getOrDefault(o2, 0);
            if (f1 != f2) {
                return f1-f2;
            }
            return o1.compareTo(o2);
        });
        video.addAll(freq.keySet());

        List<String> res = new ArrayList<>();
        while (!video.isEmpty()) {
            res.add(video.poll());
        }
        return res;
    }
}
