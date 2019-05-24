import java.util.TreeMap;

public class S0732MyCalendarIII {
    public static class MyCalendarThree {
        private TreeMap<Integer, Integer> books;

        public MyCalendarThree() {
            books = new TreeMap<>();
        }

        public int book(int start, int end) {
            books.put(start, books.getOrDefault(start, 0)+1);
            books.put(end, books.getOrDefault(end, 0)-1);
            int meetings = 0;
            int res = 0;
            for (int v : books.values()) {
                meetings += v;
                res = Math.max(res, meetings);
            }
            return res;
        }
    }
}
