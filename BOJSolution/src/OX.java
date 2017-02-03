// OX ДыБо: https://www.acmicpc.net/problem/8958
import java.util.*;

public class OX {

	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		while(N-- > 0)
		{
			String in = sc.next();
			int sum = 0; int cnt = 0;
			
			for(int i = 0; i < in.length(); i++)
			{
				if(in.charAt(i) == 'O')
				{
					sum += ++cnt;
				}else cnt = 0;
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
