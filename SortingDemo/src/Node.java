
public class Node implements Comparable<Node> {
	String name;
	int id;
	Node(String _name, int _id)	
	{
		name = _name; id = _id;
	}
	public String toString()
	{
		return "(" + name + ", " + id + ")";
	}
	
	public int compareTo(Node arg) {
		return id - arg.id;		
	}
}
