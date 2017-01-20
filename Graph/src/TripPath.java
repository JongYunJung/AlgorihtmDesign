import java.io.FileInputStream;
import java.util.*;

public class TripPath {
	static int[] p = null;
	static int[] r = null;
	static int V, E;
	public static class Edge implements Comparable<Edge>{
		int u, v, w;
		Edge(int _u, int _v, int _w){ u = _u; v = _v; w = _w;}
		
		public int compareTo(Edge arg) {
			return w - arg.w;			
		}
		public String toString()
		{
			return "(" + u + "-" + v + ", " + w + ")";
		}
	}
	static LinkedList<Edge> edges = new LinkedList<Edge>();
	static LinkedList<Edge> tree = new LinkedList<Edge>();
	
	public static void make_set()
	{
		p = new int[V];
		r = new int[V];
		for(int i = 0; i < V; i++)
		{
			p[i] = i;
			r[i] = 0;			 
		}
	}
	public static int find_set(int x)
	{
		if( x != p[x]) p[x] = find_set(p[x]);		
		return p[x];
	}
	public static void union(int x, int y)
	{
		int a = find_set(x);
		int b = find_set(y);
		if(a == b) return;
		if(r[a] > r[b]){ 
			p[b] = a;
		}
		else{		
			p[a] = b;			
			if(r[a] == r[b]) r[b]++;
		}
	}
	public static int minUpperBound(int low)
	{
		make_set();
		
		int cnt = 0;
		
		for(int i = 0; i < edges.size(); i++)
		{
			if(edges.get(i).w < low) continue;
			Edge e = edges.removeFirst();
			int a = find_set(e.u);
			int b = find_set(e.v);
			if(a == b) continue;
			
			union(a, b);			
			if(++cnt == V - 1) return e.w;
		}
		return 0xfffffff;
	}
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new FileInputStream("trip_path.txt"));	
			
			V = sc.nextInt();
			E = sc.nextInt();
			
			int from, to, weight;
			for(int i = 0; i < E; i++)
			{
				from = sc.nextInt();
				to = sc.nextInt();
				weight = sc.nextInt();				
				edges.add(new Edge(from, to, weight));
			}
			// 간선 정렬
			Collections.sort(edges);
			
			int min = 0xffffff, ret, low;
			for(int i = 0; i < edges.size(); i++)
			{
				low = edges.get(i).w;
				ret = minUpperBound(low) - low;
				min = min > ret? ret:min;
			}
			System.out.println(min);
			
			sc.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
