import java.util.HashSet;
import java.util.TreeMap;

public class S1797DesignAuthenticationManager {
    public static class AuthenticationManager {
        private int ttl = 0;
        private TreeMap<Integer, HashSet<String>> auth;

        public AuthenticationManager(int timeToLive) {
            ttl = timeToLive;
            auth = new TreeMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            auth.putIfAbsent(currentTime, new HashSet<>());
            auth.get(currentTime).add(tokenId);
        }

        public void renew(String tokenId, int currentTime) {
            int begin = currentTime-ttl;
            boolean find = false;
            Integer k = auth.higherKey(begin);
            while (k != null && k < currentTime) {
                HashSet<String> ts = auth.get(k);
                if (ts.contains(tokenId)) {
                    ts.remove(tokenId);
                    find = true;
                    break;
                }
                k = auth.higherKey(k);
            }
            if (find) {
                generate(tokenId, currentTime);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int res = 0;
            Integer k = auth.higherKey(currentTime-ttl);
            while (k != null && k < currentTime) {
                res += auth.get(k).size();
                k = auth.higherKey(k);
            }
            return res;
        }
    }
}
