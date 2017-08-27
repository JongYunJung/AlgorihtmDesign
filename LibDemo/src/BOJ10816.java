import java.util.*;

public class BOJ10816 {
	static int MAXN = 500000;
	static int[] arr = new int[MAXN + 1];
	static int N, M;
	static int lower_bound(int key)
	{
	    int lo = 0, hi = N; 
	    while (lo < hi)
	    {
	        int mid = (lo + hi) / 2; // 중간 위치

	        if (key > arr[mid])      // 오른쪽에서 탐색
	            lo = mid + 1;
	        else                     // key <= arr[mid]
	            hi = mid;
	    }
	    return lo;
	}
	static int upper_bound(int key)
	{
	    int lo = 0, hi = N;
	    while (lo < hi)
	    {
	        int mid = (lo + hi) / 2; // 중간 위치

	        if (key >= arr[mid])     // 왼쪽에서 탐색
	            lo = mid + 1; 
	        else                     // key >= arr[mid]
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
			int hi = upper_bound(key);
			
			System.out.printf("%d ", hi - lo);
		}
		sc.close();
	}
}
