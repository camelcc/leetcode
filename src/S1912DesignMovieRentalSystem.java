import java.util.*;

// https://leetcode.com/problems/design-movie-rental-system/discuss/1302299/Java-Solution-HashMap%2BTreeSet
public class S1912DesignMovieRentalSystem {
    class MovieRentingSystem {
        class Node{
            int shop;
            int movie;
            int price;
            Node(int shop, int movie, int price){
                this.shop=shop; this.movie=movie; this.price=price;
            }
        }

        Map<Integer, Map<Integer, Node>> map = new HashMap<>(); //shop -> movie

        Map<Integer, TreeSet<Node>> unrented = new HashMap<>(); // movie
        TreeSet<Node> rented = new TreeSet<>((a, b)->{
            if(a.price==b.price){
                if(a.shop==b.shop) return a.movie-b.movie;
                return a.shop-b.shop;
            }
            return a.price-b.price;
        });

        public MovieRentingSystem(int n, int[][] es) {
            for(int[] e:es){
                Node node = new Node(e[0], e[1], e[2]);
                Map<Integer, Node> sub = map.getOrDefault(e[0], new HashMap());
                sub.put(e[1], node);
                map.putIfAbsent(e[0], sub);
                TreeSet<Node> list = unrented.getOrDefault(e[1],
                        new TreeSet<>((a,b)->{
                            if(a.price==b.price) {return a.shop-b.shop;}
                            else return a.price-b.price;
                        }));
                list.add(node);
                unrented.putIfAbsent(e[1], list);
            }
        }

        public List<Integer> search(int movie) {
            TreeSet<Node> nodes = unrented.get(movie);
            List<Integer> list = new ArrayList<>();
            if(nodes==null) return list;
            Iterator<Node> it = nodes.iterator();
            while(it.hasNext() && list.size()<5){
                Node node = it.next();
                list.add(node.shop);
            }
            return list;
        }

        public void rent(int shop, int movie) {
            Node node = map.get(shop).get(movie);
            rented.add(node);
            unrented.get(node.movie).remove(node);
        }

        public void drop(int shop, int movie) {
            Node node = map.get(shop).get(movie);
            rented.remove(node);
            unrented.get(node.movie).add(node);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> rst = new ArrayList<>();
            Iterator<Node> it = rented.iterator();
            while(it.hasNext() && rst.size()<5){
                Node next = it.next();
                rst.add(Arrays.asList(next.shop, next.movie));
            }
            return rst;
        }
    }
}
