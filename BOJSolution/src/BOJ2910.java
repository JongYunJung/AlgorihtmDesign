// 빈도 정렬 https://www.acmicpc.net/problem/2910
import java.util.*;

public class BOJ2910 {
	static class DATA implements Comparable<DATA>{
		int cnt, pos;		// 빈도수, 위치
		DATA(int c, int p){
			cnt = c; pos = p;
		}
		public int compareTo(DATA arg0) {
			if (cnt == arg0.cnt)
				return pos - arg0.pos; // 빈도수가 같을때 처음 나온 위치 비교
			else
				return arg0.cnt - cnt;					
		}
	};
	static HashMap<Integer, DATA> map = new HashMap<Integer, DATA>(); 
	
	public static <K, V extends Comparable<? super V>> 
	LinkedHashMap<K, V> sortByValue(HashMap<K, V> map) {
	    
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
	    
	    Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
	        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
	            return (o1.getValue()).compareTo(o2.getValue() );
	        }
	    });

	    LinkedHashMap<K, V> result = new LinkedHashMap<K, V>();
	    for (Map.Entry<K, V> entry : list) {
	        result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		
		for (int i = 0; i < N; i++)	{
			
			int key = sc.nextInt();			
			DATA ret = map.get(key);
			
			if(ret == null)	{
				map.put(key, new DATA(1, i));
			}else{
				ret.cnt++;
				//map.replace(key, ret);
			}
		}
		LinkedHashMap<Integer, DATA> sorted = sortByValue(map);		
		
		for(Map.Entry<Integer, DATA> val: sorted.entrySet()){
			
			for(int i = 0; i < val.getValue().cnt; i++)
				System.out.print(val.getKey() + " ");
		}
		
		System.out.println();
		sc.close();		
	}
}
