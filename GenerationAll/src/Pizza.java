import java.util.Scanner;

public class Pizza {	
	static int N, M, U;
	static int[] SETS = new int[100];
	static boolean[] bit = new boolean[100];
	static int min;
	public static void subset(int k, int cnt, int set)
	{
		if (cnt > min) return;
		if (set == U && cnt < min)
		{
			min = cnt;
			System.out.printf("%d°³> ", cnt);
			for (int i = 0; i < k; i++)
				if (bit[i]) System.out.printf("%d ", i);
			System.out.printf("\n");		
			return;
		}
		if (k == N + 1)	return;

		bit[k] = true; subset(k + 1, cnt + 1, set | SETS[k]);
		bit[k] = false; subset(k + 1, cnt, set);
	}
	public static void subset_counting()
	{
		int subset;
		for(int i = 0; i < (1 << N); i++)
		{
			subset = (i << 1);
			
			int set = 0, cnt = 0;
			for(int j = 1; j <= N; j++)
			{
				if((subset & (1 << j)) != 0)
				{
					set |= SETS[j]; cnt++;
				}
			}
			if(set == U && cnt < min)
				min = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 1; i <= N; i++)
		{
			U |= (1 << i);
			SETS[i] |= (1 << i);
		}

		int u, v;
		for (int i = 0; i < M; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			
			SETS[u] |= (1 << v);
			SETS[v] |= (1 << u);
			
		}
		min = 0xffffff;	
		//subset(1, 0, 0);
		subset_counting();
		System.out.println(min);
		
		sc.close();
	}

}
