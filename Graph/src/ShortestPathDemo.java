import java.io.FileInputStream;
import java.util.*;

public class ShortestPathDemo {
	static int[][] G = new int[100][100];				// ���� ���
	static ArrayList<LinkedList<Node>> adjList = null;	// ���� ����Ʈ
	static int[] D = new int[100];						// �Ÿ� ����
	static int[] P = new int[100];						// �ִ� ��� Ʈ��
	
	static int V, E;
	private static class Node{
		int v, w;
		Node(int a, int b){ v= a; w = b;}
	}
	
	// D[], P[] �迭 ��� �ϱ�
	public static void printResult()
	{
		for(int i = 1; i <= V; i++)
		{
			System.out.printf("%d ", D[i]);
		}
		System.out.printf("\n");
		for(int i = 1; i <= V; i++)
		{
			System.out.printf("%d ", P[i]);
		}
		System.out.printf("\n");
	}
	// BFS + ���� ���
	public static void bfs(int v)
	{
		for(int i = 1; i <= V; i++)
			D[i] = 0xffffff;
		D[v] = 0; P[v] = v;
		
		Queue<Integer> Q = new LinkedList<Integer>();		
		Q.add(v);		
		while(!Q.isEmpty())
		{
			v = Q.remove();
			
			for(int i = 1; i <= V; i++)
			{
				if(G[v][i] != 0 && D[i] > D[v] + G[v][i])
				{
					D[i] = D[v] + G[v][i];
					P[i] = v;
					Q.add(i);
					
				}	
			}
		}
	}
	// BFS + ���� ����Ʈ
	public static void bfs_adjList(int v)
	{
		System.out.println("��������Ʈ ����ϱ�");
		for(int i = 1; i <= V; i++)
			D[i] = 0xffffff;
		D[v] = 0; P[v] = v;
		
		Queue<Integer> Q = new LinkedList<Integer>();		
		Q.add(v);		
		while(!Q.isEmpty())
		{
			v = Q.remove();
			
			for(int i = 0; i < adjList.get(v).size(); i++)
			{
				Node node = adjList.get(v).get(i);
				if(D[node.v] > D[v] + node.w)
				{
					D[node.v] = D[v] + node.w;
					P[i] = node.v;
					Q.add(i);					
				}	
			}
		}
	}
	// �켱 ���� ť�� ����Ǵ� ����
	private static class Vertex implements Comparable<Vertex>{
		int id;
		int key;
		Vertex(int a, int b)
		{
			id = a; key = b; 
		}
		public String toString()
		{
			return id +" " + key + "\n";			
		}		
		public int compareTo(Vertex arg) {			 
			return id - arg.id;
		}
	}
	// ���ͽ�Ʈ�� + �켱���� ť
	public static void dijkstra(int v)
	{
		for(int i = 1; i <= V; i++)
			D[i] = 0xffffff;
		D[v] = 0; P[v] = v;
		
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();		
		Q.add(new Vertex(v, D[v]));		
		while(!Q.isEmpty())
		{
			Vertex vt = Q.remove();
			if(vt.key > D[vt.id]) continue;
			
			v = vt.id;
			for(int i = 1; i <= V; i++)
			{
				if(G[v][i] != 0 && D[i] > D[v] + G[v][i])
				{
					D[i] = D[v] + G[v][i];
					P[i] = v;
					Q.add(new Vertex(i, D[i]));
					
				}	
			}
		}
	}
	// �Է� ���� ���� ��ķ� �б�
	public static void readInput(String fileName)
	{
		try{
			Scanner sc;
			if(fileName != null)
				sc = new Scanner(new FileInputStream(fileName));
			else
				sc = new Scanner(System.in);
			
			V = sc.nextInt();
			E = sc.nextInt();
			
			int from, to, weight;
			for(int i = 0; i < E; i++)
			{
				from = sc.nextInt();
				to = sc.nextInt();
				weight = sc.nextInt();				
				G[from][to] = G[to][from] = weight;
			}			
			sc.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	// �Է� ���� ���� ����Ʈ�� �б�
	public static void readtoAdjList(String fileName)
	{
		try{
			Scanner sc;
			if(fileName != null)
				sc = new Scanner(new FileInputStream(fileName));
			else
				sc = new Scanner(System.in);
			
			V = sc.nextInt();
			E = sc.nextInt();
			adjList = new  ArrayList<LinkedList<Node>>();			
			for(int i = 0; i <= V; i++)
				adjList.add(new LinkedList<Node>());
			
			int from, to, weight;
			for(int i = 0; i < E; i++)
			{
				from = sc.nextInt();
				to = sc.nextInt();				
				weight = sc.nextInt();
				adjList.get(from).add(new Node(to, weight));
				adjList.get(to).add(new Node(from, weight));
			}			
			sc.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {		
		readInput(null);
		
		System.out.println("���ͽ�Ʈ�� �˰���");
		System.out.println("----------------");
		dijkstra(1); printResult();
		System.out.println("----------------");
		
	}
}
