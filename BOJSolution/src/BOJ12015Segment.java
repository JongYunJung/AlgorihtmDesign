import java.util.*;

public class BOJ12015Segment {
   
    static final int MAX = 1000000;
    static int[] st;
    static int query(int id, int l, int r, int s, int e){
    	if(s <= l && r <= e) return st[id];
    	if(r < s || e < l) return 0;
    	int mid = (l + r)/2;
    	return Math.max(query(id*2, l, mid, s, e), query(id*2+1, mid + 1, r, s, e)); 
    }
    
    static void update(int id, int l, int r, int p, int v){
    	if( p < l || r < p) return;
    	
    	st[id] = Math.max(st[id], v);
    	
    	if(l == r) return;
    	
    	int mid = (l + r)/2;
    	update(id*2, l, mid, p, v);
    	update(id*2 + 1, mid+1, r, p, v);
    }
    
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int size = 1;
        while(size < MAX) 
        	size <<= 1;
        size <<= 1;        
        st = new int[size];
        
        int ans = 0;
        for(int i = 0; i < N; i++){
        	int val = sc.nextInt();
        	int ret = query(1, 1, MAX, 1, val - 1);
        	
        	update(1, 1, MAX, val, ret + 1);
        	ans = Math.max(ans, ret + 1);
        }
        System.out.println(ans);
        sc.close();
    }
}

