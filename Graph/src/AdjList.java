import java.util.*;

public class AdjList {
	public static ArrayList<Integer>[] G;
	
	
	
	
	public static void main(String[] args){
		
		G = new ArrayList[5];
		
		for(int i = 0; i < 5; i++)
			G[i] = new ArrayList<Integer>();
		
		G[0].add(1);
		G[0].add(2);
		G[0].add(3);
		
		for(int v: G[0])
			System.out.println(v);
		
		
	}
}