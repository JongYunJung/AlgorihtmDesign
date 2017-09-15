import java.util.Scanner;

public class BOJ2281 {
	static int[] memo = new int[1001];
	static int[] len = new int[1001];
	static int[] sum = new int[1001];
	static int n, m;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();	
		
		for(int i = 1; i <= n; i++)
		{
			len[i] = sc.nextInt();
			sum[i] =  sum[i - 1] + len[i];
		}
		
		memo[0] = 0;
		
		for(int i = 1; i < n; i++){
			memo[i] = memo[i - 1] + (m - len[i]) * (m - len[i]);	// i, i - 1이 다른줄
			
			for(int j = i - 1; j >= 0; j--)	// i와 i - 1이 같은 줄
			{
				if(sum[i] - sum[j] + (i - j - 1) > m) break;
				int t = (m - (sum[i] - sum[j] + (i - j - 1)));
				memo[i] = Math.min(memo[i], memo[j] + t * t);
			}
		}
		memo[n] = memo[n - 1];
		for(int i = n - 2; i >= 0; i--)
		{
			if(sum[n] - sum[i] + (n - i - 1) > m) break;			
			memo[n] = Math.min(memo[n], memo[i]);
		}
		System.out.println(memo[n]);
		sc.close();
	}
}
