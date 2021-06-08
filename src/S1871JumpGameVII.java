import java.util.LinkedList;

public class S1871JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length()-1) == '1') {
            return false;
        }
        LinkedList<Integer> bfs = new LinkedList<>();
        bfs.offer(0);
        int processed = 0;

        while (!bfs.isEmpty()) {
            int p = bfs.poll();
            if (p == s.length()-1) {
                return true;
            }
            for (int i = Math.max(p+minJump, processed); i <= Math.min(s.length()-1, p+maxJump); i++) {
                if (s.charAt(i) == '0') {
                    bfs.offer(i);
                }
            }

            processed = Math.min(p+maxJump+1, s.length()-1);
        }
        return false;
    }
}
