import java.util.HashMap;

public class S1166DesignFileSystem {
    class FileSystem {
        private HashMap<String, Integer> fs;

        public FileSystem() {
            fs = new HashMap<>();
        }

        public boolean create(String path, int value) {
            if (path.isEmpty() || path.equals("/") || fs.containsKey(path)) {
                return false;
            }
            int s = path.lastIndexOf('/');
            if (s != 0) {
                String parent = path.substring(0, s);
                if (!fs.containsKey(parent)) {
                    return false;
                }
            }
            fs.put(path, value);
            return true;
        }

        public int get(String path) {
            return fs.getOrDefault(path, -1);
        }
    }

}
