import java.io.FileInputStream;
import java.util.Scanner;
public class DFS {
	static int[][] G = new int[100][100];
	static boolean[] visited = new boolean[100];
	static int V, E;
	public static void dfs(int v)
	{
		visited[v] = true;
		System.out.print(v + " ");
		for(int i = 1; i <= V; i++)
		{
			if(G[v][i] == 1 && visited[i] == false)
				dfs(i);
		}
	}
	public static void solve()
	{
		Scanner	sc = new Scanner(System.in);		
			
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
		dfs(1);
		sc.close();		
	}
	public static void solve(String file)
	{
		Scanner sc; FileInputStream fin;
		
		try{
			if(file == null) sc = new Scanner(System.in);
			else{
				fin = new FileInputStream(file);
				sc = new Scanner(fin);
			}
			
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
			dfs(1);
			sc.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
