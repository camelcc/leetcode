public class S2224MinimumNumberOperationsConvertTime {
    public int convertTime(String current, String correct) {
        int cur = min(current), cor = min(correct);
        int diff = cor-cur, res = 0;
        res += diff >= 60 ? diff/60 : 0;
        diff = diff%60;
        res += diff >= 15 ? diff/15 : 0;
        diff = diff%15;
        res += diff >= 5 ? diff/5 : 0;
        diff = diff%5;
        res += diff;
        return res;
    }

    private int min(String time) {
        return (time.charAt(0)*10+time.charAt(1))*60 + time.charAt(3)*10 + time.charAt(4);
    }
}
