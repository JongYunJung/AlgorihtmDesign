import java.util.Scanner;

public class ToyComposition {
	static int MAX = 100;
	static boolean[] isChild = new boolean[MAX + 1];
	static int[][] tree = new int[MAX + 1][MAX + 1];
	static int[] cnt= new int[MAX + 1];
	static int N, M;

	public static void calc(int v, int n)
	{
		cnt[v] += n;
		if (!isChild[v]) return;
		for (int i = 1; i <= N; i++)
		{
			if (tree[v][i] != 0)
				calc(i, n * tree[v][i]);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int x, y, k;
		for (int i = 0; i < M; i++)
		{
			x = sc.nextInt();
			y = sc.nextInt();
			k = sc.nextInt();
			
			isChild[x] = true;
			tree[x][y] = k;
		}
		
		calc(N, 1);
		for (int i = 1; i <= N; i++)
			if (!isChild[i])
				System.out.printf("%d %d\n", i, cnt[i]);
		
		sc.close();
	}

}
