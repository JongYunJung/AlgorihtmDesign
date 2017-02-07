// 최단 경로  https://www.acmicpc.net/problem/1753
import java.util.*;
public class ShortestPath {
    static Map<Integer, List<Vertex>> adjList;
    static int[] D = new int[20001];
    static int[] P = new int[20001];
    static int N, M, S; 
    
    // 우선 순위 큐에 저장되는 정보
    private static class Vertex implements Comparable<Vertex>{
        int v; // 정점
        int d; // 가중치 또는 거리
        Vertex(int a, int b)
        {
            v = a; d = b; 
        }
        public String toString()
        {
            return "(" + v +"/" + d + ")";   
        }  
        public int compareTo(Vertex arg) {    
            return d - arg.d;
        }
    }
    // 다익스트라 + 우선순위 큐
    public static void dijkstra(int v)
    {
        for(int i = 1; i <= N; i++)
        {
        	D[i] = 0xfffffff; 
        }
        D[v] = 0; P[v] = v;

        PriorityQueue<Vertex> PQ = new PriorityQueue<Vertex>();  
        PQ.add(new Vertex(v, D[v]));

        while(!PQ.isEmpty())
        {
            Vertex from = PQ.poll();
            if(from.d > D[from.v]) continue;

            List<Vertex> list = adjList.get(from.v);
            if(list == null) continue;
            for(Vertex to: list)
            {
            	
                if(D[to.v] > D[from.v] + to.d)
                {
                     D[to.v] = D[from.v] + to.d;
                     //P[to.v] = from.v;
                     PQ.add(new Vertex(to.v, D[to.v]));
                } 
            }
        }
    }
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();	
        M = sc.nextInt();	
        S = sc.nextInt();	          

        adjList = new HashMap<Integer, List<Vertex>>(); // 인접 리스트
        int from, to, weight;
        for(int i = 0; i < M; i++)
        {
            from = sc.nextInt();
            to = sc.nextInt();    
            weight = sc.nextInt();

            List<Vertex> list = adjList.get(from);
            if(list == null)
            {
                list = new LinkedList<Vertex>();
                list.add(new Vertex(to, weight));
                adjList.put(from, list);
            }else list.add(new Vertex(to, weight));
        }
        dijkstra(S); 
        
        for(int i = 1; i <= N; i++)
        	if(D[i] == 0xfffffff)
        		System.out.println("INF");
        	else
        		System.out.println(D[i]);           
        
        sc.close();
    }
}