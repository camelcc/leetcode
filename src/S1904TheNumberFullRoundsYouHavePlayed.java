public class S1904TheNumberFullRoundsYouHavePlayed {
    public int numberOfRounds(String startTime, String finishTime) {
        int start = time(startTime), end = time(finishTime);
        if (end < start) {
            end = end + 24*60;
        }
        int l = (int)Math.ceil(start*1.0/15);
        int r = (int)Math.floor(end*1.0/15);
        return Math.max(0, r-l);
    }

    private int time(String time) {
        int hour = Integer.valueOf(time.substring(0, 2));
        int min = Integer.valueOf(time.substring(3));
        return hour*60+min;
    }
}
