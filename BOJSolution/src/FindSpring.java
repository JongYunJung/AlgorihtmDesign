// 분수찾기 https://www.acmicpc.net/problem/1193

import java.util.Scanner;

public class FindSpring {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		int sum = 0, cnt = 1;
		while(true)
		{
			sum += cnt;
			if(sum >= N) break;
			cnt++;
		}
		int diff = N - (sum - cnt) - 1;
		
		System.out.print(cnt - diff);
		System.out.print("/");
		System.out.print(1 + diff);
		sc.close();
	}
}
