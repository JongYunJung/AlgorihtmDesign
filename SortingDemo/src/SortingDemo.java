import java.util.*;

public class SortingDemo {	
	
	public static void sortArray()
	{
		String[] names = new String[]{"�ŵ���", "�̼���", "���缮", "��ȣ��", "�豸��"};
		
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
		names.add("�ŵ���");		names.add("�̼���");
		names.add("���缮");		names.add("��ȣ��");
		names.add("�豸��");		
		
		Collections.sort(names);
		
		for(String name: names)
			System.out.println(name);
		
		System.out.println("----------------------------");
		
		Collections.sort(names, Collections.reverseOrder());
		
		for(String name: names)
			System.out.println(name);
	}
	
/*	public static void usingComparator()
	{
		Comparator<Node> compareNode = new Comparator<Node>(){
			
			public int compare(Node n1, Node n2)
			{
				return n2.id - n1.id;
			}
		};
		
		Node[] nodes = new Node[5];
		nodes[0] = new Node("�ŵ���", 3);
		nodes[1] = new Node("�̼���", 1);
		nodes[2] = new Node("���缮", 5);
		nodes[3] = new Node("��ȣ��", 4);
		nodes[4] = new Node("�豸��", 2);
		
		Arrays.sort(nodes, compareNode);
		
		for(Node node: nodes)
			System.out.println(node);;
		
	}*/
	public static void usingComparable()
	{
		
		Node[] nodes = new Node[5];
		nodes[0] = new Node("�ŵ���", 3);
		nodes[1] = new Node("�̼���", 1);
		nodes[2] = new Node("���缮", 5);
		nodes[3] = new Node("��ȣ��", 4);
		nodes[4] = new Node("�豸��", 2);
		
		Arrays.sort(nodes);
		
		for(Node node: nodes)
			System.out.println(node);;
		
		Arrays.sort(nodes, Collections.reverseOrder());
		for(Node node: nodes)
			System.out.println(node);;
	}
	public static void bsdemo()
	{
		int[] arr = new int[]{3, 17, 29, 25, 16, 77, 12, 8, 62, 2, 7, 33, 45, 19};
		Arrays.sort(arr);	
		for(int val: arr)
			System.out.print(val + " ");
		System.out.println();
		System.out.println("25 => " + Arrays.binarySearch(arr, 25)); // �ε���
		System.out.println("55 => " + Arrays.binarySearch(arr, 55)); // ����
	}
	public static void main(String[] args)
	{
		//sortArray();
		//sortArrayList();
		//usingComparator();
		//usingComparable();
		bsdemo();
	}
}
