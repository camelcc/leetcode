import java.util.HashMap;
import java.util.TreeMap;

public class S0911OnlineElection {
    class TopVotedCandidate {
        HashMap<Integer, Integer> votes;
        TreeMap<Integer, Integer> map;
        int mostPerson = -1;
        int mostVotes = 0;

        public TopVotedCandidate(int[] persons, int[] times) {
            votes = new HashMap<>();
            map = new TreeMap<>();

            for (int i = 0; i < persons.length; i++) {
                int v = persons[i];
                int t = times[i];
                int pv = votes.getOrDefault(v, 0) + 1;
                votes.put(v, pv);
                if (pv >= mostVotes) {
                    mostVotes = pv;
                    mostPerson = v;
                }
                map.put(t, mostPerson);
            }
        }

        public int q(int t) {
            return map.get(map.floorKey(t));
        }
    }
}
