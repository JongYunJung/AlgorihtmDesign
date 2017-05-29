import java.util.Scanner;
public class BOJ2193 {
	
	static int[] memo;
	static int tiling(int n)
	{
		if(memo[n] != 0) return memo[n];
		if(n <= 2) return memo[n] = 1;
		return memo[n] = (tiling(n - 2) + tiling(n - 1));
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n + 1];
		System.out.println(tiling(n));
		
		sc.close();
	}
}
