import java.util.*;

public class BOJ10816_2 {
	static int MAXN = 500000;
	static int[] arr = new int[MAXN + 1];
	static int N, M;
	static int lower_bound(int key)
	{
		int lo = 0, hi = N;
		while(lo < hi)
		{
			int mid = (lo + hi) / 2;
			if(arr[mid] < key)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
 		
		Arrays.sort(arr, 0, N);		
		
		M = sc.nextInt();
		for(int i = 0; i < M; i++)
		{
			int key = sc.nextInt();			
			
			int lo = lower_bound(key);
			
			if(lo < 0 || arr[lo] != key)
				System.out.print("0 ");
			else			
				System.out.print((lower_bound(key + 1) - lo) + " ");				
		}
		sc.close();
	}
}
