import java.util.*;

public class S1233RemoveSubFoldersFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        HashSet<String> folders = new HashSet<>();
        for (String f : folder) {
            List<String> paths = folders(f);
            if (Collections.disjoint(folders, paths)) {
                res.add(f);
            }
            folders.add(f);
        }
        return res;
    }

    private List<String> folders(String folder) {
        String[] folders = folder.substring(1).split("/");
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String f : folders) {
            sb.append("/").append(f);
            res.add(sb.toString());
        }
        return res;
    }
}
