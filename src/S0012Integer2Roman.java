import java.util.HashMap;

public class S0012Integer2Roman {
    public String intToRoman(int num) {
        int[] vals = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 3, 2, 1};
        HashMap<Integer, String> st = new HashMap<>();
        st.put(1000, "M");
        st.put(900, "CM");
        st.put(500, "D");
        st.put(400, "CD");
        st.put(100, "C");
        st.put(90, "XC");
        st.put(50, "L");
        st.put(40, "XL");
        st.put(10, "X");
        st.put(9, "IX");
        st.put(5, "V");
        st.put(4, "IV");
        st.put(3, "III");
        st.put(2, "II");
        st.put(1, "I");

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= vals[i]) {
                res.append(st.get(vals[i]));
                num -= vals[i];
            } else {
                i++;
            }
        }
        return res.toString();
    }
}
