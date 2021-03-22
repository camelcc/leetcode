import java.util.*;

public class S1600ThroneInheritance {
    static class ThroneInheritance {
        class People {
            String name;
            boolean dead = false;
            List<People> children;

            public People(String n) {
                name = n;
                children = new ArrayList<>();
            }

            public void addChildren(People c) {
                children.add(c);
            }
        }

        private People family;
        private HashMap<String, People> map;

        public ThroneInheritance(String kingName) {
            family = new People(kingName);
            map = new HashMap<>();
            map.put(kingName, family);
        }

        public void birth(String parentName, String childName) {
            People c = new People(childName);
            map.put(childName, c);
            map.get(parentName).addChildren(c);
        }

        public void death(String name) {
            map.get(name).dead = true;
        }

        public List<String> getInheritanceOrder() {
            List<String> res = new ArrayList<>();
            traverse(family, res);
            return res;
        }

        private void traverse(People p, List<String> res) {
            if (!p.dead) {
                res.add(p.name);
            }
            for (People c : p.children) {
                traverse(c, res);
            }
        }
    }
}
