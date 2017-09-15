import java.util.*;

public class BOJ11066 {
	static int K;
	static int[] file;
	static int[] sum;
	static int[][] memo;
	static int mergeFiles(int s, int e){
		
		if(s == e) return 0;
		if(memo[s][e] != 0) return memo[s][e];
		int min = 0xfffffff;
		for(int i = s; i < e; i++)
		{
			int l = mergeFiles(s, i);
			int r = mergeFiles(i + 1, e);
			int m = 0;
			if(s == 0) m = sum[e];
			else m = sum[e] - sum[s - 1];
			if(l + r + m < min) min = l + r + m;
		}
		return memo[s][e] = min;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
		{
			K = sc.nextInt();
			file = new int[K];
			sum = new int[K];
			memo = new int[K][K];
			
			file[0] = sum[0] = sc.nextInt();
			
			for(int i = 1; i < K; i++)
			{
				file[i] = sc.nextInt();
				sum[i] = sum[i - 1] + file[i]; 
			}
			
			System.out.println(mergeFiles(0, K - 1));
			
		}
		sc.close();
	}

}
