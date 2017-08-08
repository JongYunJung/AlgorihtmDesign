import java.util.*;

public class SortingDemo {	
	static class Node implements Comparable<Node> {
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
			return name.compareTo(arg.name);
			//return id - arg.id;		
		}
	}

	// string 문자열들 정렬하기
	public static void sortArray()
	{
		String[] names = new String[]{"신동엽", "이수근", "유재석", "강호동", "김구라"};
		
		Arrays.sort(names);
		
		for(String name: names)
			System.out.println(name);
		
		System.out.println("----------------------------");
		 
		Arrays.sort(names, Collections.reverseOrder());
		for(String name: names)
			System.out.println(name);
	}
	public static void sortArrayList()
	{
		List<String> names = new ArrayList<String>();		 
		names.add("신동엽");		names.add("이수근");
		names.add("유재석");		names.add("강호동");
		names.add("김구라");		
		
		Collections.sort(names);
		
		for(String name: names)
			System.out.println(name);
		
		System.out.println("----------------------------");
		
		Collections.sort(names, Collections.reverseOrder());
		
		for(String name: names)
			System.out.println(name);
	}
	
	public static void usingComparator()
	{
		Comparator<Node> compareNode = new Comparator<Node>(){
			
			public int compare(Node n1, Node n2)
			{
				return n2.id - n1.id;
			}
		};
		
		Node[] nodes = new Node[5];
		nodes[0] = new Node("신동엽", 3);
		nodes[1] = new Node("이수근", 1);
		nodes[2] = new Node("유재석", 5);
		nodes[3] = new Node("강호동", 4);
		nodes[4] = new Node("김구라", 2);
		
		Arrays.sort(nodes, compareNode);
		
		for(Node node: nodes)
			System.out.println(node);;
		
	}
	public static void usingComparable()
	{
		
		Node[] nodes = new Node[5];
		nodes[0] = new Node("신동엽", 3);
		nodes[1] = new Node("이수근", 1);
		nodes[2] = new Node("유재석", 5);
		nodes[3] = new Node("강호동", 4);
		nodes[4] = new Node("김구라", 2);
		
		// 오름차순 정렬
		Arrays.sort(nodes);		
		for(Node node: nodes)
			System.out.println(node);;
		
		System.out.println("----------------------------");
			 
		// 내림차순 정렬
		Arrays.sort(nodes, Collections.reverseOrder());
		for(Node node: nodes)
			System.out.println(node);;
	}

	public static void main(String[] args)
	{
		//sortArray();
		//sortArrayList();
		//usingComparator();
		usingComparable();

	}
}
