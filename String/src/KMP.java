// 찾기 https://www.acmicpc.net/problem/1786
// kmp 구현해서 문제 풀기
// T와 P의 길이는 N, M은 1 에서 1000000

import java.util.*;
	
public class KMP 
{
	static int[] next = new int[1000010];
	static int[] pos =  new int[1000010];
	static String t;
	static String p;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		 
		t = sc.nextLine();
		p = sc.nextLine();
		
		int n = t.length(); int m = p.length();
		t = t + "\0\0";
		p = p + "\0\0";
		next[0]= -1;
		int i = 0, j = -1;
		
		while(i < m)
		{
			while(j >= 0 && p.charAt(j) != p.charAt(i))
				j = next[j];
			i++; j++;
			next[i] = j;
		}
		
		i = 0; j = 0;
		int cnt = 0;
		while(i < n)
		{
			while(j >= 0 && p.charAt(j) != t.charAt(i))
				j = next[j];
			i++; j++;
			if(j == m)
			{
				pos[cnt++] = i - j;
				//j = 0;
			}
		}
		System.out.println(cnt);
		
		for(int k = 0; k < cnt; k++)
			System.out.printf("%d ", pos[k] + 1);
		
		System.out.printf("\n");
		sc.close();
	}
}
