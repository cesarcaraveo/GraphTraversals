import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Graph {
    // int is the key and it represents the unique value of the node
    // List<Node> is the value and it represents all the nodes the int node is connected to
    HashMap<Integer, List<Node>> nodes = new HashMap<>();

    public Graph() {

    }
    
    // creates node -- takes the value and ensures it doesn't already exist to avoid duplicate values
    public void createNode(int val) {
    	Node newNode = new Node(val);
    	
    	if (!doesExist(val)) {
    		nodes.put(newNode.getValue(), new ArrayList<>());
    	}
    	
    	else {
    		System.err.println("Node already exists!");
    	}
    }

    public void addEdge(Node firstNode, Node secondNode) {
        // if node is not in graph, it needs to be added to the graph and its list<Node> needs to be created
        if (!nodes.containsKey(firstNode.getValue())) {        	
            nodes.put(firstNode.getValue(), new ArrayList<>());
        }
        
        nodes.get(firstNode.getValue()).add(secondNode);
        
        // add node to other node's list
        if (!nodes.containsKey(secondNode.getValue())) {        	
            nodes.put(secondNode.getValue(), new ArrayList<>());
        }
        
        nodes.get(secondNode.getValue()).add(firstNode);
    }
    
    // ensures no duplicate nodes are created
    public boolean doesExist(int val) {
    	return nodes.containsKey(val);
    }

}