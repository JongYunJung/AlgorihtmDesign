/*
5
0 2 7 3 10
2 0 3 5 4
7 3 0 6 1
3 5 6 0 9
10 4 1 9 0

´ä> 16
 */
import java.util.Scanner;

public class TSPDemo {
	static int N;
	static int[][] G;
	static int[][] D;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		G = new int[N][N];
		D = new int[1 << N][N];
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++){				
				G[i][j]	= sc.nextInt();				 
			}
		}		
		for(int i = 0; i < (1 << N); i++)
			for(int j = 0 ; j < N; j++)
				D[i][j] = 0xffffff;
		
		D[1][0] = 0;
		
		for(int cur = 0; cur < (1 << N); cur++)
		{
			for(int last = 0; last < N; last++)
			{
				if((cur & (1 << last)) == 0) continue;
				
				int pre = cur - (1 << last);
				
				for(int i = 0; i < N; i++)
				{
					if((pre & (1 << i)) == 0) continue;
					D[cur][last] = Math.min(D[cur][last], D[pre][i] + G[i][last]);
					printBit(pre, i, D[pre][i]);
				}
				printBit(cur, last, D[cur][last]);
				System.out.println("-------------------");
			}
		}
		int min = 0xffffff;
		for(int i = 1; i < N; i++)
			min = Math.min(min, D[(1 << N) - 1][i] + G[i][0]);
		
		System.out.println(min);
		sc.close();
	}
	static void printBit(int visit, int last, int d){
		System.out.print("[");
		for(int i = 0; i < N; i++)
			if((visit & (1 << i)) == 0) System.out.print(0);
			else System.out.print(1);
		System.out.println("][" + last + "] = " + d);
	}
}
