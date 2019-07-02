import java.util.*;

public class S0950RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        int[] r = new int[deck.length];
        for (int i = 0; i < res.size(); i++) {
            r[res.get(i)] = deck[i];
        }
        return r;
    }
}
