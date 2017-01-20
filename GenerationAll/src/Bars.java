import java.util.Scanner;

public class Bars {
	static int L, N;
	static int[] bars = new int[30];

	public static boolean subset(int k, int len)
	{
		if (len > L) return false;
		if (k == N)
		{
			if (len == L) return true;
			return false;
		}
		
		if(subset(k + 1, len + bars[k])) return true;
		if(subset(k + 1, len)) return true;

		return false;
	}
	
	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		while (T-- > 0)
		{

			L = sc.nextInt();
			N = sc.nextInt();
			
			for (int i = 0; i < N; i++)
				bars[i] = sc.nextInt();

			if (subset(0, 0)) System.out.println("YES");
			else System.out.println("NO");
		}
		sc.close();
	}
}
