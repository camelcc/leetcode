import java.util.Stack;

public class S0388LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] paths = input.split("\n");
        String longestPath = "";

        Stack<String> dirs = new Stack<>();
        String prefix = "";

        for (String p : paths) {
            int level = 0;
            while (p.startsWith("\t")) {
                level++;
                p = p.substring(1);
            }
            while (dirs.size() > level) {
                String s = dirs.pop();
                if (dirs.empty()) {
                    prefix = "";
                } else {
                    prefix = prefix.substring(0, prefix.length() - s.length() - 1);
                }
            }

            String path = prefix.isEmpty() ? p :  prefix + "/" + p;
            if (!p.contains(".")) {
                dirs.push(p);
                prefix = prefix.isEmpty() ? p : prefix + "/" + p;
            } else {
                if (longestPath.length() < path.length()) {
                    longestPath = path;
                }
            }
        }

        return longestPath.length();
    }
}
