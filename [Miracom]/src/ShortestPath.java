// �ִ� ���  https://www.acmicpc.net/problem/1753
import java.util.*;
public class ShortestPath {
    static Map<Integer, List<Vertex>> adjList;
    static int[] D = new int[20001];
    static int[] P = new int[20001];
    static int N, M, S; 
    
    // �켱 ���� ť�� ����Ǵ� ����
    private static class Vertex implements Comparable<Vertex>{
        int v; // ����
        int d; // ����ġ �Ǵ� �Ÿ�
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
    // ���ͽ�Ʈ�� + �켱���� ť
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

        adjList = new HashMap<Integer, List<Vertex>>(); // ���� ����Ʈ
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