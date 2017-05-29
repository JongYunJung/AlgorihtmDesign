import java.util.Scanner;

// 1,2,3 더하기
// N --> 11이하
public class BOJ9095 {

	static int decrease(int n)
	{
		if(n < 0) return 0;
		if(n == 0) return 1;
		int cnt = 0;
		
		cnt += decrease(n - 1);
		cnt += decrease(n - 2);
		cnt += decrease(n - 3);
		return cnt;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0)
		{
			int N = sc.nextInt();			
			System.out.println(decrease(N));
			
		}
		sc.close();
	}
}
