import java.util.Scanner;

public class ACMHotel {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0)
		{
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			
			int q = N / H;
			int r = N % H;
			if(r != 0) q++;
			else r = H;
			System.out.println(r* 100+ q);
		}
		
		sc.close();
	}
}
