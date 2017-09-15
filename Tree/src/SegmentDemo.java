
public class SegmentDemo {
	static int[] arr = new int[]{2,6,4,5,7,9,10,1,9};
	static int N = arr.length;
	static int[] st;
	
	static void build(int id, int l, int r){
		if(l == r) {
			st[id] = arr[l];
			return;
		}		
		int mid = (l + r)/2;
		build(id*2, l, mid); 
		build(id*2 + 1, mid + 1, r);
		st[id] = st[id*2] + st[id*2 + 1];
	}
	static int query(int id, int l, int r, int s, int e)
	{
		if(r < s || e < l) return 0;
		if(s <= l && r <=  e) return st[id];
		int mid = (l + r)/2;
		
		int a = query(id*2, l, mid, s, e); 
		int b = query(id*2 + 1, mid + 1, r, s, e);
		
		return a + b;		
	}
	public static void main(String[] args)	{
		System.out.println("½ÃÀÛ");		
		int size = 1, cnt = 0;
		while(size < N)
		{
			cnt++;
			size <<= 1;
		}
		st = new int[1 << (cnt + 1)];
		build(1, 0, N - 1);
		
		System.out.println(query(1, 0, N - 1, 1, 5));
		System.out.println(query(1, 0, N - 1, 0, N - 1));
	}
}
