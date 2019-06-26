public class S0925LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int ni = 0, ti = 0;
        while (ni < name.length()) {
            if (ti >= typed.length()) {
                return false;
            }
            if (name.charAt(ni) != typed.charAt(ti)) {
                if (ti == 0 || typed.charAt(ti-1) != typed.charAt(ti)) {
                    return false;
                }
                ti++;
            } else {
                ni++;
                ti++;
            }
        }
        while (ti < typed.length() && typed.charAt(ti) == typed.charAt(ti-1)) {
            ti++;
        }
        return ti == typed.length();
    }
}
