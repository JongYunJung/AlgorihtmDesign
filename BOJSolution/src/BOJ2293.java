import java.util.Scanner;

public class BOJ2293 {
	static int[][] memo = new int[2][10001];
	static int[] coin = new int[101];
	static int N, K;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		for(int i = 1; i <= N; i++)
			coin[i] = sc.nextInt();
		
		memo[0][0] = memo[1][0] = 1;
		int cur = 0, pre  = 0;
		for(int i = 1; i <= N; i++)
		{
			cur = i % 2;
			pre = (cur == 0)? 1:0;
			for(int j = 1; j <= K; j++)
			{
				if(j >= coin[i])
					memo[cur][j] = memo[cur][j - coin[i]] + memo[pre][j];
				else
					memo[cur][j] = memo[pre][j];
			}
		}
		System.out.println(memo[cur][K]);
		sc.close();
	}

}
