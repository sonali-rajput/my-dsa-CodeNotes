package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
    
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
    
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
    
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
    
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
    
        CloneGraph cg = new CloneGraph();
        Node clonedGraph = cg.cloneGraph(node1);
    
        // Quick verification
        System.out.println("Original Node: " + node1.val + ", Cloned Node: " + clonedGraph.val);
        System.out.println("Cloned Neighbors of Node " + clonedGraph.val + ": ");
        for (Node neighbor : clonedGraph.neighbors) {
            System.out.println(neighbor.val);
        }
    }
    

    HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {

        if (node == null) {
            return node;
        }

        if(visited.containsKey(node)){
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());
        
        // add the cloneNode to the hashmap
        visited.put(node, cloneNode);

        // checking for neighbours
        for(Node neighbour:node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbour)); 
        }
         return cloneNode;
        
    }
}
