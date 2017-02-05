// 줄세우기 https://www.acmicpc.net/problem/2252
import java.util.*;

public class lineSort {

	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();	
	static boolean[] visit = new boolean[32001];
	static int[] indeg = new int[32001];
	
	static Stack<Integer> order = new Stack<Integer>();	
	static int N, M, s;
	
	
	static void DFS(int v)
	{
		visit[v] = true;
		List<Integer> list = map.get(v);
		if(list != null)
		{
			for(int val: list)			
			{
				if(visit[val] == false)
					DFS(val);
			}
		}
		order.push(v);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 학생수(정점수)
		M = sc.nextInt();	// 비교횟수(간선수)
		for(int i = 0; i < M; i++)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			List<Integer> list;
			
			if(map.containsKey(u))
			{
				list = map.get(u);
				list.add(v);
			}else
			{
				list = new LinkedList<Integer>();
				list.add(v);
				map.put(u, list);
			}
			indeg[v]++;
		}
		
		for(int i = 1; i <= N; i++)
		{
			if(indeg[i] == 0)
				DFS(i);
		}
		
		while(!order.isEmpty())
			System.out.print(order.pop() + " ");
		System.out.println();
		sc.close();
	}
}
