import java.util.ArrayList;
import java.util.List;

public class S0071SimplifyPath {
    public String simplifyPath(String path) {
        String p = path.replaceAll("/+", "/");
        if (p.endsWith("/")) {
            p = p.substring(0, p.length()-1);
        }
        if (p.startsWith("/")) {
            p = p.substring(1);
        }
        String[] c = p.split("/");
        List<String> components = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i].equals(".")) {
                continue;
            }
            if (c[i].equals("..")) {
                if (components.isEmpty()) {
                    continue;
                }

                components.remove(components.size()-1);
            } else {
                components.add(c[i]);
            }
        }
        if (components.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < components.size(); i++) {
            res.append("/");
            res.append(components.get(i));
        }
        return res.toString();
    }
}
