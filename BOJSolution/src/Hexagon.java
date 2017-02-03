// ¹úÁý https://www.acmicpc.net/problem/2292

import java.util.Scanner;

public class Hexagon {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		
		N -= 1;
		int cnt = 1;
		while(N > 0)
		{
			N -= cnt * 6;
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}
