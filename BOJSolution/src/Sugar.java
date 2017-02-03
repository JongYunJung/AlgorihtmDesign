// ¼³ÅÁ ¹è´Þ https://www.acmicpc.net/problem/2839

import java.util.Scanner;

public class Sugar {
//	public static void main(String[] args)
//	{
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		int cnt = -1;
//		int q = N / 5;
//		int r = N % 5;
//		
//		if(r == 0) System.out.println(q);
//		else{
//			int i;
//			for(i = q; i > 0; i--)
//			{
//				if((r % 3) == 0) break;
//				r += 5;
//			}
//			if(i > 0)
//				System.out.println(i + r/3);
//			else if((N % 3) == 0) System.out.println(N/3);
//			else System.out.println(-1);
//		}
//		sc.close();
//	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] memo = new int[5000 + 1];
		int N = sc.nextInt();
		
		memo[1] = -1; memo[2] = -2; memo[4] = -1;
		memo[3] = 1; memo[5] = 1;
		if(N > 5)
		{
			for(int i = 6; i <= N; i++)
			{
				int min = 0xfffff;
				if(memo[i - 5] != -1)
					min =  memo[i - 5];
				if(memo[i - 3] != -1)
					min = memo[i - 3] < min? memo[i-3]:min;
				
				if(min < 0xfffff) memo[i] = min + 1;	
			}
		}
		System.out.println(memo[N]);
		sc.close();
	}
}
