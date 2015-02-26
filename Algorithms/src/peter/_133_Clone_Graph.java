package peter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Util.UndirectedGraphNode;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the
 * graph looks like the following:
 * 
 * <pre>
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 * </pre>
 * 
 * @author ylkang Feb 26, 2015
 */
public class _133_Clone_Graph {

	private static Map<Integer, UndirectedGraphNode> cloneMap = new HashMap<Integer, UndirectedGraphNode>();

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		cloneMap.put(node.label, clone);
		clone.neighbors = cloneNeighbors(node.neighbors, node, clone);

		return clone;

	}

	private static List<UndirectedGraphNode> cloneNeighbors(
			List<UndirectedGraphNode> neighbors, UndirectedGraphNode node,
			UndirectedGraphNode clone) {
		List<UndirectedGraphNode> cloneList = new ArrayList<UndirectedGraphNode>();
		for (UndirectedGraphNode neighbor : neighbors) {
			if (cloneMap.containsKey(neighbor.label)) {
				cloneList.add(cloneMap.get(neighbor.label));
			} else {
				cloneMap.put(neighbor.label, neighbor);
				cloneList.add(cloneGraph(neighbor));
			}
		}

		return cloneList;
	}

	public static void main(String[] args) {
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node3 = new UndirectedGraphNode(3);
		UndirectedGraphNode node4 = new UndirectedGraphNode(4);
		UndirectedGraphNode node5 = new UndirectedGraphNode(5);

		node.neighbors.add(node1);
		node.neighbors.add(node5);
		node1.neighbors.add(node5);
		node1.neighbors.add(node2);
		node2.neighbors.add(node3);
		node3.neighbors.add(node4);
		node3.neighbors.add(node4);
		node4.neighbors.add(node5);
		node4.neighbors.add(node5);

		System.out.println(cloneGraph(node));
	}
}