
public class Node<T> 
{
	T	key;
	Node<T> left;
	Node<T> right;
	Node(T val){ this(val, null, null);}
	Node(T val, Node<T> l, Node<T> r){
		key = val; left = l; right = r;
	}
}
