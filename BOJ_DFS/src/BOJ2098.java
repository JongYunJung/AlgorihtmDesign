/*
	* ���ǿ���ȸ(3).cpp
	*
	https://www.acmicpc.net/problem/2098
	*/
import java.util.*;

public class BOJ2098 {
	
	
	static int[][] G = new int[16][16];
	static int[][] dp = new int[1 << 16][16];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++)	// 0�� ���� ���� ����
			for (int j = 0; j < n; j++)
				G[i][j] = sc.nextInt();
		
		for (int i = 0; i < (1 << n); i++)
			for (int j = 0; j < n; j++)
				dp[i][j] = 0xfffffff;
		
		dp[1][0] = 0;
		
		for (int visit = 1; visit < (1 << n); visit++) // visit: �湮�� �������� ����
		{
			for (int last = 0; last < n; last++)		// last: ������ �湮 ����
			{
				if ((visit & (1 << last)) == 0) continue; // 1�� �湮���� ���� ��� ����
				
				int prev = visit - (1 << last); 		 // ������ �湮 ������ ����
				
				for (int v = 0; v < n; v++)				 // prev ������ ������ �湮 �����鿡 ����
				{
					if (G[v][last]==0 || (prev & (1 << v)) == 0) // ������ ���ų�, ��湮 ���� ���� 
						continue;
					
					dp[visit][last] = Math.min(dp[visit][last], dp[prev][v] + G[v][last]);
				}
			}
		}
		int ans = 0xfffffff;
		for (int i = 1; i < n; i++)
			ans = Math.min(ans, dp[(1 << n) - 1][i] + G[i][0]);
		System.out.println(ans);
		sc.close();
	}
}
