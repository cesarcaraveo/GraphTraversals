
public class Driver {

	public static void main(String[] args) {
		/***
		 * Test cases
		 */
		// Testing printConnectedNodes() -- two nodes -- one edge
		Graph graph = new Graph();
		
		Node one = graph.createNode(1);
		Node two = graph.createNode(2);
		
		graph.addEdge(one, two);
		graph.printConnectedNodes(graph, one.getValue()); // should print out 2
		graph.printConnectedNodes(graph, two.getValue()); // should print out 1
		
		// Testing addEdge() to ensure no duplicate edges can be created
		graph.addEdge(one, two); // should output error
		graph.addEdge(two, one); // should output error

		// test printGraph() to test graphs
		graph.printGraph(); // should print out Node 1 || Connected Nodes: 2; Node 2 || Connected Nodes: 1
		
		Graph emptyGraph = new Graph();
		emptyGraph.printGraph(); // should print out "Graph is empty!"
		
	}

}
