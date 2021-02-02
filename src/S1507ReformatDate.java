import java.util.HashMap;

public class S1507ReformatDate {
    public String reformatDate(String date) {
        HashMap<String, String> month = new HashMap<>();
        int mi = 1;
        for (String m : new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}) {
            month.put(m, mi < 10 ? "0" + mi : String.valueOf(mi));
            mi++;
        }
        String[] d = date.split(" ");
        StringBuilder sb = new StringBuilder(d[2]);
        sb.append("-");
        sb.append(month.get(d[1]));
        sb.append("-");
        int day = 0;
        for (char c : d[0].toCharArray()) {
            if (Character.isDigit(c)) {
                day = day*10 + (c-'0');
            }
        }
        sb.append(day < 10 ? "0"+day : String.valueOf(day));
        return sb.toString();
    }
}
