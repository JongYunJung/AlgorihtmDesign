import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
public class BFSDemo {
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
	public static void readInput(String fileName) throws FileNotFoundException 
	{
			Scanner sc = new Scanner(new FileInputStream(fileName));
			
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
			sc.close();
		
	}
	public static void main(String[] args) {
		
		try{
			readInput("graph_input.txt");
			bfs(1);
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
