// 트리의 높이와 너비 https://www.acmicpc.net/problem/2250
// 틀린 부분 수정하기

import java.util.*;


public class TreeHeight {
	
	static int[] r = new int[10001];
	static int[] l = new int[10001];
		
	static int cnt = 0, maxH = 0; 
	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	static void treeHeight(int v, int h)
	{
		if(v == -1) return;
		if(maxH < h) maxH = h;
		
		treeHeight(l[v], h + 1);
		//----------------------------		
		cnt = cnt + 1;
		List<Integer> list = map.get(h);
		if(list == null) {
			list = new LinkedList<Integer>();
			list.add(cnt);
			map.put(h, list);			
		}else list.add(cnt);
		//----------------------------
		treeHeight(r[v], h + 1);				
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int node, left, right;
		
		for(int i = 0; i < N; i++)
		{
			node = sc.nextInt();
			left = sc.nextInt();
			right = sc.nextInt();
			
			if(left != -1) 
			{
				l[node] = left;
			}else l[node] = -1;
			
			if(right != -1) 
			{
				r[node] = right;
			}else r[node] = -1;
		}
		treeHeight(1, 1);
		
		int min, max, width = 0, height = 1;
		
		for(int key = 1; key <= maxH; key++)
		{
			List<Integer> list = map.get(key);
			
			min = Collections.min(list);
			max = Collections.max(list);
			int diff = max - min + 1;
			
			System.out.println("높이:" + key + ", min = " + min + ", max" + max );
			
			if(diff > width)
			{
				width = diff;
				height = key;
			}	
		}
		System.out.println(height + " " + width);
		
		sc.close();
	}
}
