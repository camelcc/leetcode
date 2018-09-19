import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class S0332ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<Integer> jfk = validTickets("JFK", tickets);
        for (int i = 0; i < jfk.size(); i++) {
            boolean[] visited = new boolean[tickets.length];
            Stack<Integer> itinerary = new Stack<>();
            List<String> res = new ArrayList<>();
            if (dfs(jfk.get(i), itinerary, visited, tickets)) {
                while (!itinerary.isEmpty()) {
                    int ti = itinerary.pop();
                    res.add(0, tickets[ti][1]);
                }
                res.add(0, "JFK");
                return res;
            }
        }
        return new ArrayList<>();
    }

    private boolean dfs(int ticket, Stack<Integer> itinerary, boolean[] visited, String[][] tickets) {
        itinerary.push(ticket);
        if (itinerary.size() == tickets.length) {
            return true;
        }
        visited[ticket] = true;
        for (int t : validTickets(tickets[ticket][1], tickets)) {
            if (visited[t]) {
                continue;
            }
            if (dfs(t, itinerary, visited, tickets)) {
                return true;
            }
        }
        int i = itinerary.pop();
        visited[i] = false;
        return false;
    }

    private List<Integer> validTickets(String from, String[][] tickets) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(from)) {
                res.add(i);
            }
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return tickets[o1][1].compareTo(tickets[o2][1]);
            }
        });
        return res;
    }
}
