import java.util.Scanner;

public class BOJ1080 {
	static int[][] arr = new int[50][50];
	static int N, M;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				int t = sc.nextInt();
				arr[i][j] ^= t; 
			}
		}
		int[] row = new int[N];
		int[] col = new int[M];
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				row[i] += arr[i][j];
				col[j] += arr[i][j];
			}
		}
		sc.close();
	}
}
