import java.util.Scanner;
import java.util.*;
public class BFS {
	static int[][] G = new int[100][100];
	static boolean[] visited = new boolean[100];
	static int V, E;
	public static void bfs(int v)
	{
		Queue<Integer> Q = new LinkedList<Integer>();
		visited[v] = true;
		Q.add(v);		
		System.out.print(v + " ");
		while(!Q.isEmpty())
		{
			v = Q.remove();
			
			for(int i = 1; i <= V; i++)
			{
				if(G[v][i] == 1 && visited[i] == false)
				{
					visited[i] = true;
					Q.add(i);
					System.out.print(i + " ");
				}	
			}
		}
	}
	public static void solve()
	{
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		int from, to;
		for(int i = 0; i < E; i++)
		{
			from = sc.nextInt();
			to = sc.nextInt();
			
			G[from][to] = 1;
			G[to][from] = 1;
		}
		bfs(1);
		
		sc.close();
	}
}
