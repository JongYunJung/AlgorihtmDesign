/*
	 * BOJ3653.java
	 *
	 *  Created on: 2017. 8. 7.
	 *      Author: JongYun
*/
import java.util.*;
public class BOJ3653 {
	
	static int N, M;
	static int[] pos = new int[100001];
	static int[] fw = new int[200010];;

	static int LSB(int x){	return x & -x; }

	static void updatePoint(int p, int v)
	{
		for( ;p <= N + M; p += LSB(p))
			fw[p] += v;
	}
	// ±¸°£ÇÕ [1, a]
	static int query(int a)
	{
		int sum = 0;
		for( ;a > 0; a -= LSB(a))
			sum += fw[a];
		return sum;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	
		for(int tc = 0; tc < T; tc++)
		{
			N = sc.nextInt();
			M = sc.nextInt();

			for(int i = 1; i <= M + N; i++)	
				fw[i] = 0;

			for(int i = 1; i <= N; i++)
			{
				pos[i] = M + i;
				updatePoint(M + i,1);
			}

			int dvd, top = M;
			for(int i = 0; i < M; i++)
			{
				dvd = sc.nextInt();
				System.out.printf("%d ", query(pos[dvd] - 1) );
				updatePoint(pos[dvd], -1);
				pos[dvd] = top;
				updatePoint(top, 1);
				top--;
			}
			System.out.println();
		}
		sc.close();
	}


}
