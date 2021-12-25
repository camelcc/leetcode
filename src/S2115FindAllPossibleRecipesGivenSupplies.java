import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class S2115FindAllPossibleRecipesGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();

        HashSet<String> visited = new HashSet<>();
        LinkedList<String> fulfill = new LinkedList<>(Arrays.asList(supplies));
        while (!fulfill.isEmpty()) {
            String f = fulfill.poll();
            visited.add(f);
            for (int i = 0; i < ingredients.size(); i++) {
                ingredients.get(i).remove(f);
                if (ingredients.get(i).isEmpty() && !visited.contains(recipes[i])) {
                    fulfill.add(recipes[i]);
                }
            }
        }
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).isEmpty()) {
                res.add(recipes[i]);
            }
        }
        return res;
    }
}
