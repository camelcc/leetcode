public class S0649Dota2Senate {
    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder(senate);
        while (sb.length() > 1) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);

            boolean deleted = false;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == c) {
                    continue;
                }

                deleted = true;
                sb.deleteCharAt(i);
                break;
            }
            if (!deleted) {
                break;
            }
        }
        char c = sb.charAt(0);
        return c == 'R' ? "Radiant" : "Dire";
    }
}
