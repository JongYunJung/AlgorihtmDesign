import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class topologySortDemo {
	static int[][] G = new int[100][100];	
	static boolean[] visited = new boolean[100];
	static int[] indeg = new int[100];
	static int[] order = new int[100];
	static int idx = -1;
	static int V, E;
	
	public static void printOrder()
	{
		for(int i = idx; i >= 0; i--)
			System.out.printf("%d ", order[i]);
		System.out.printf("\n");
	}
	public static void dfs(int v)
	{
		visited[v] = true;		
		for(int i = 1; i <= V; i++)
		{
			if(G[v][i] == 1 && visited[i] == false)
				dfs(i);
		}
		order[++idx] = v;
	}
	public static void solve()
	{
		for(int i = 1; i <= V; i++)
		{
			if(indeg[i] == 0)
				dfs(i);
		}
		printOrder(); 
	}
	public static void solve_degree()
	{
		Queue<Integer> Q = new LinkedList<Integer>();
		for(int i = 1; i <= V; i++)
			if(indeg[i] == 0) Q.add(i);
		
		while(!Q.isEmpty())
		{
			int v = Q.poll();
			System.out.print(v + " ");
			for(int i = 1; i <= V; i++)
			{
				if(G[v][i] == 1 && indeg[i] != 0)
				{
					indeg[i]--;
					if(indeg[i] == 0) Q.add(i);
				}
			}
		}
	}
	
	public static void readInput(String fileName)
	{
		try{
			Scanner sc = new Scanner(new FileInputStream(fileName));
					
			V = sc.nextInt();
			E = sc.nextInt();
			
			int from, to;
			for(int i = 0; i < E; i++)
			{
				from = sc.nextInt();
				to = sc.nextInt();
								
				G[from][to] = 1;
				indeg[to]++;
			}			
			sc.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {		
		readInput("topo_input.txt");
		solve_degree();
	}
}
