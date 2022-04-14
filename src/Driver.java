
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
		graph.printConnectedNodes(graph, one); // should print out 2
		graph.printConnectedNodes(graph, two); // should print out 1
		
		// Testing addEdge() to ensure no duplicate edges can be created
		graph.addEdge(one, two); // should output error
		graph.addEdge(two, one); // should output error

		// TODO: create print graph function to test empty graph
		Graph emptyGraph = new Graph();
		
	}

}
