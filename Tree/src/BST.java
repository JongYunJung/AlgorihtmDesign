


public class BST {
	private static class Node {
		int key;
		Node left; 
		Node right;
		
		Node(int key)
		{
			this(key, null, null);
		}
		
		Node(int key, Node l, Node r)
		{
			this.key = key; left = l; right = r; 
		}
	}
	private Node root;
	
	public BST() { root = null;}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	public void insert(int x, Node n)
	{
		if(n == null) return;
		
	}
	public void remove(int x)
	{
		
	}
}
