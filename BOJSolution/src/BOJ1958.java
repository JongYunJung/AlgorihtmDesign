import java.util.Scanner;

public class BOJ1958 {
	static int[][][] memo = new int[101][101][101];
	static String x, y, z;
	
	static int LCS(int i, int j, int k){
		if(i < 0 || j < 0 || k < 0) return 0;
		if(memo[i][j][k] != -1) return memo[i][j][k];
		
		if(x.charAt(i) == y.charAt(j) && y.charAt(j) == z.charAt(k))
			return memo[i][j][k] = LCS(i - 1, j - 1, k - 1) + 1;
		else{
			int max = -1;
			max = Math.max(max, LCS(i - 1, j, k));
			max = Math.max(max, LCS(i, j - 1, k));
			max = Math.max(max, LCS(i, j, k - 1));
			max = Math.max(max, LCS(i - 1, j -1, k));
			max = Math.max(max, LCS(i - 1, j, k - 1));
			max = Math.max(max, LCS(i, j - 1, k - 1));
			return memo[i][j][k] = max;
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		x = sc.next();
		y = sc.next();
		z = sc.next();
		int a = x.length(); int b = y.length();
		int c = z.length();
		for(int i = 0; i < a; i++)
		for(int j = 0; j < b; j++)
		for(int k = 0; k < c; k++)
			memo[i][j][k] = -1;
		System.out.println(LCS(a - 1, b - 1, c - 1));
		sc.close();
	}
}
