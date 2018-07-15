import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0133CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        HashMap<Integer, UndirectedGraphNode> graph = new HashMap<>();
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        graph.put(node.label, res);

        List<UndirectedGraphNode> nodes = new ArrayList<>();
        nodes.add(node);

        List<UndirectedGraphNode> visited = new ArrayList<>();

        while (!nodes.isEmpty()) {
            UndirectedGraphNode originNode = nodes.remove(0);
            UndirectedGraphNode newNode = graph.get(originNode.label);
            assert newNode != null;

            for (UndirectedGraphNode originalNeighbor : originNode.neighbors) {
                UndirectedGraphNode newNeighbor = graph.get(originalNeighbor.label);
                if (newNeighbor == null) {
                    newNeighbor = new UndirectedGraphNode(originalNeighbor.label);
                    graph.put(originalNeighbor.label, newNeighbor);
                }
                if (originalNeighbor != originNode) {
                    newNode.neighbors.add(newNeighbor);
                    if (!visited.contains(newNeighbor)) {
                        if (!nodes.contains(originalNeighbor)) {
                            nodes.add(originalNeighbor);
                        }
                    }
                } else {
                    newNode.neighbors.add(newNeighbor);
                }
            }


            visited.add(newNode);
        }

        return res;
    }
}
