public class S1323Maximum69Number {
    public int maximum69Number (int num) {
        String n = String.valueOf(num);
        n = n.replaceFirst("6", "9");
        return Integer.valueOf(n).intValue();
    }
}
