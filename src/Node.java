public class Node {
	private int value;
	private boolean visited;
	
	public Node(int val) {
		value = val;
		visited = false;
	}
	
	// getter methods
	public int getValue() {
		return value;
	}
	
	public boolean getIfVisited() {
		return visited;
	}
	
	// setter methods
	public void setValue(int val) {
		value = val;
	}
	
	public void setVisited(boolean bool) {
		visited = bool;
	}
}
