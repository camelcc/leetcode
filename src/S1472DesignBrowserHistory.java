import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S1472DesignBrowserHistory {
    public static class BrowserHistory {
        List<String> history;
        int current;

        public BrowserHistory(String homepage) {
            history = new ArrayList<>();
            history.add(homepage);
            current = 0;
        }

        public void visit(String url) {
            current++;
            if (current == history.size()) {
                history.add(url);
            } else {
                assert current < history.size();
                history.set(current, url);
                int i = history.size()-1;
                while (i > current) {
                    history.remove(i);
                    i--;
                }
            }
        }

        public String back(int steps) {
            int i = current-steps;
            if (i < 0) {
                i = 0;
            }
            current = i;
            return history.get(i);
        }

        public String forward(int steps) {
            int i = current + steps;
            if (i >= history.size()) {
                i = history.size()-1;
            }
            current = i;
            return history.get(i);
        }
    }
}
