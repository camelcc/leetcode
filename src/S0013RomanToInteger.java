import java.util.HashMap;

public class S0013RomanToInteger {
    public int romanToInt(String s) {
        HashMap<String, Integer> st = new HashMap<>();
        st.put("I", 1);
        st.put("V", 5);
        st.put("X", 10);
        st.put("L", 50);
        st.put("C", 100);
        st.put("D", 500);
        st.put("M", 1000);
        st.put("IV", 4);
        st.put("IX", 9);
        st.put("XL", 40);
        st.put("XC", 90);
        st.put("CD", 400);
        st.put("CM", 900);
        String[] romains = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int result = 0;
        int maxRomain = 0;
        String remains = s;
        while (!remains.isEmpty()) {
            for (int i = maxRomain; i < romains.length; i++, maxRomain++) {
                if (remains.startsWith(romains[i])) {
                    result += st.get(romains[i]);
                    remains = remains.substring(romains[i].length());
                    break;
                }
            }
        }
        return result;
    }
}
