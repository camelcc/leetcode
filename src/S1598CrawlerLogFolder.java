import java.util.Stack;

public class S1598CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> path = new Stack<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (!path.isEmpty()) {
                    path.pop();
                }
            } else if (log.equals("./")) {
                continue;
            } else {
                path.push(log);
            }
        }
        return path.size();
    }
}
