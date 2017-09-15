import java.util.*;
public class BOJ1005 {
	static ArrayList<Integer>[] G = new ArrayList[1001];
	static int N, K, W;
	static int[] D = new int[1001];
	static int[] indeg = new int[1001];
	static int[] time = new int[1001];
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while(T-- > 0)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			
			for(int i = 1; i <= N; i++)
			{
				G[i] = new ArrayList<Integer>();
				D[i] = sc.nextInt();
			}
			for(int i = 0; i < K; i++){
				int u = sc.nextInt();
				int v = sc.nextInt();				
				G[u].add(v);
				indeg[v]++;
			}
			W = sc.nextInt();
			
			Queue<Integer> Q = new LinkedList<Integer>();
			for(int i = 1; i <= N; i++)
				if(indeg[i] == 0) Q.add(i);
			
			while(!Q.isEmpty()){
				int u = Q.poll();
				
				time[u] += D[u];				
				if(u == W) break;
				
				
				for(int v: G[u]){
					if(indeg[v] != 0){
						indeg[v]--;
						time[v] = Math.max(time[v], time[u]);
					}
					if(indeg[v] == 0)
						Q.add(v);				
				}
			}
			System.out.println(time[W]);
			for(int i = 1; i <= N; i++)
				indeg[i] = time[i] = 0;
			Q.clear();
		}
		
		sc.close();
	}
}
