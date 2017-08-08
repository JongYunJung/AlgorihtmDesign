import java.util.Scanner;

public class BOJ2156 {

	static int[] memo;
	static int[] score;
	static int N;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		
		memo = new int[N + 1];
		score = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			score[i] = sc.nextInt();
		
		memo[1] = score[1];
		memo[2] = score[1] + score[2];
		
		for(int i = 3; i <= N; i++)
		{
			memo[i] = Math.max(score[i] + memo[i - 2], score[i] + score[i - 1] + memo[i - 3]);
			memo[i] = Math.max(memo[i], memo[i - 1]);
		}		
		System.out.println(memo[N]);
		sc.close();
	}
}
