import java.util.*;

// https://leetcode.com/problems/delete-duplicate-folders-in-system/discuss/1360745/Java-Solution-with-Explanation
public class S1948DeleteDuplicateFoldersSystem {
    class Folder{
        String name;
        Map<String, Folder> map;
        List<Folder> list;
        String key;
        boolean del;

        Folder(String name){
            this.name = name;
            map = new HashMap<>();
            list = new ArrayList<>();
            key = "";
            del = false;
        }
    }

    Folder root = new Folder("");
    Map<String, Integer> keys = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        for (List<String> path : paths){
            addPath(path);
        }

        for (Folder f : root.list){
            generateKey(f);
        }

        for (Folder f : root.list){
            updateDeleteStatus(f);
        }

        List<List<String>> results = new ArrayList<>();

        for (List<String> path : paths){
            if (isValid(path))
                results.add(path);
        }

        return results;
    }

    private boolean isValid(List<String> path){
        Folder current = root;

        for (String f : path){
            current = current.map.get(f);

            if (current.del)
                return false;
        }

        return true;
    }

    private void updateDeleteStatus(Folder f){
        if (f.list.size() > 0 && keys.get(f.key) > 1){
            f.del = true;
            return;
        }

        for (Folder fold : f.list){
            updateDeleteStatus(fold);
        }
    }

    private String generateKey(Folder fold){
        StringBuilder sb = new StringBuilder();

        if (fold.list.size() == 0)
            return sb.toString();

        // sort to order matches
        Collections.sort(fold.list, (a, b) -> a.name.compareTo(b.name));

        for (Folder f : fold.list){
            sb.append('(');
            sb.append(f.name + generateKey(f));
            sb.append(')');
        }

        String key = sb.toString();
        fold.key = key;
        keys.put(key, keys.getOrDefault(key, 0) + 1);

        return key;
    }

    private void addPath(List<String> path){
        Folder current = root;

        for (String f : path){
            if (!current.map.containsKey(f)){
                Folder fold = new Folder(f);
                current.map.put(f, fold);
                current.list.add(fold);
            }

            current = current.map.get(f);
        }
    }
}
