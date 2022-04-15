import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Graph {
    // int is the key and it represents the unique value of the node
    // List<Node> is the value and it represents all the nodes the int node is connected to
    private HashMap<Integer, List<Node>> nodes;

    public Graph() {
    	nodes = new HashMap<>();
    }
    
    // creates node -- takes the value and ensures it doesn't already exist to avoid duplicate values
    public Node createNode(int val) {
    	// if node value is new
    	if (!doesExist(val)) {
        	Node newNode = new Node(val); // create new node
    		nodes.put(newNode.getValue(), new ArrayList<>()); // add new node to graph
        	return newNode; // return the created node
    	}
    	
    	else {
    		System.err.println("Node already exists!");
     		return null;
    	}
    }

    public void addEdge(Node firstNode, Node secondNode) {
        // if node is not in graph, it needs to be added to the graph and its list<Node> needs to be created
        if (!nodes.containsKey(firstNode.getValue())) {        	
            nodes.put(firstNode.getValue(), new ArrayList<>());
        }
        
        // check if edge has already been created
        if (nodes.get(firstNode.getValue()).contains(secondNode)) {
        	System.err.println("Edge already exists!");
        	return;
        }
        
        // if second node hasn't been created, must create it and add it first
        if (!nodes.containsKey(secondNode.getValue())) {        	
            nodes.put(secondNode.getValue(), new ArrayList<>());
        }
        
        // add first node to second node's list
        nodes.get(firstNode.getValue()).add(secondNode);
        
        // add second node to other first node's list
        nodes.get(secondNode.getValue()).add(firstNode);
    }
    
    // ensures no duplicate nodes are created
    public boolean doesExist(int nodeValue) {
    	return nodes.containsKey(nodeValue);
    }
    
    // prints all the nodes and their edges
    public void printGraph() {
    	// if graph is empty, print out empty graph
    	if (nodes.keySet().size() == 0) {
    		System.out.println("Graph is empty!");
    	}
    	
    	
    	// if graph is not empty, print out every node and its connected nodes
    	else {
    		for(int node : nodes.keySet()) {
    			System.out.print("Node " + node + " || Connected Nodes: ");
    			printConnectedNodes(this, node);
    		}
    	}
    }
    
    // prints all nodes the argument node is connected to
    public void printConnectedNodes(Graph graph, int node) {
    	// check to make sure node exists
    	if (!doesExist(node)) {
    		System.err.println("Node doesn't exist!");
    	}
    	
    	// if node does exist
    	else {
    		// get list of connected nodes
    		List<Node> connectedNodes = graph.getNodes().get(node);
    		
    		// if list is empty, print message
    		if (connectedNodes.isEmpty()) {
    			System.out.println("No connected nodes!");
    		}
    		
    		// print all node values
    		else {
    			for (Node connectedNode : connectedNodes) {
    				System.out.println(connectedNode.getValue());
    			}
    		}
    	}
    }
    
    // getter method for nodes in graph
    public HashMap<Integer, List<Node>> getNodes() {
    	return nodes;
    }

}