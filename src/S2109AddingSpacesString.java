public class S2109AddingSpacesString {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0, si = 0;
        while (i < s.length()) {
            if (si < spaces.length && i == spaces[si]) {
                sb.append(' ');
                si++;
            }
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
