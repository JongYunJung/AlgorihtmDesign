import java.util.*;

public class BOJ2613 {
	static int MAXN = 300;
	static int[] arr = new int[MAXN + 1];	
	static int N, M;
	static boolean isPossible(int val)
	{
		int cnt = 0, sum = 0;
		for(int i = 0; i < N; )
		{
			sum += arr[i];
			if(sum > val)
			{
				cnt++; sum = 0;
				continue;
			}
			i++;
		}
		if(cnt <= M) return true;
		else return false;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();		
				
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();		 
 	
		int lo = 1, hi = 300 * 100;
		
		while(lo < hi)
		{
			int mid = (lo + hi) / 2;			
			
			if(isPossible(mid))		
				hi = mid;
			else 
				lo = mid + 1;
		}
		System.out.println(lo);
		int cnt = 0, sum = 0;
		for(int i = 0; i < N; )
		{
			sum += arr[i];
			cnt++;
			if(sum > lo)
			{
				System.out.print(cnt + " ");
				cnt = sum = 0; continue;
			}
			i++;
		}
		sc.close();
	}
}
