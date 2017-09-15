import java.util.Scanner;

public class BOJ1890 {

	static int[][] MAP;
	static long[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		MAP =  new int[N][N];
		memo =  new long[N][N];
		for(int i = 0; i < N; i++)
		for(int j = 0; j < N; j++)
			MAP[i][j] = sc.nextInt();
		
		memo[0][0] = 1;
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(memo[i][j] == 0 || MAP[i][j] == 0) continue;
				if(i + MAP[i][j] < N)
					memo[i + MAP[i][j]][j] += memo[i][j];
				if(j + MAP[i][j] < N)
					memo[i][j + MAP[i][j]] += memo[i][j];
			}
		}
		System.out.println(memo[N - 1][N - 1]);
		
		sc.close();

	}

}
