import java.util.Scanner;

// https://www.acmicpc.net/problem/1463

public class BOJ1463 {

	static int[] memo;
	static int solve(int n)
	{
		if(memo[n] != 0) return memo[n];
		if(n == 1) return 0;
		
		int min = 0xffffff;
		
		if((n % 3) == 0)
			min = Math.min(min,  solve(n / 3));
		if((n % 2) == 0)
			min = Math.min(min,  solve(n / 2));
		
		min = Math.min(min,  solve(n - 1));
		
		return memo[n] = min + 1;
	}
	static int solve_iter(int n)
	{
		memo[1] = 0;
		
		for(int i = 2; i <= n; i++)
		{
			int min = 0xffffff;			
			if((i % 3) == 0)
				min = Math.min(min, memo[i / 3]);
			if((i % 2) == 0)
				min = Math.min(min, memo[i / 2]);
			
			min = Math.min(min, memo[i - 1]);
			
			memo[i] = min + 1;
		}
		return memo[n];
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		memo = new int[n + 1];
		
		//System.out.println(solve(n));
		System.out.println(solve_iter(n));
		sc.close();
	}
}
