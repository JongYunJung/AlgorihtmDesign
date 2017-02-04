import java.util.*;

// LCA https://www.acmicpc.net/problem/11437

public class LCA {
	
	static int[] p = new int[50001];
	static boolean[] visit = new boolean[50001];
	
	static int findLCA(int v1, int v2)
	{
		int v, lca = 1;
		
		v = v1;
		while(v != 0)
		{
			visit[v] = true;
			v = p[v];
		}
		
		v = v2;		
		while(v != 0)
		{
			if(visit[v]) 
			{
				lca = v; break;
			}
			v = p[v];
		}
		v = v1;
		while(v != 0)
		{
			visit[v] = false;
			v = p[v];
		}
		return lca;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
				
		for(int i = 0; i < N - 1; i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			if(p[v2] == 0) p[v2] = v1;
			else p[v1] = v2;
		}
		
		int M = sc.nextInt();
		
		for(int i = 0; i < M; i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			System.out.println(findLCA(v1, v2));
		}
		sc.close();
	}
	
}
