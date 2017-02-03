// 2577 숫자의 개수
import java.util.*;

public class CountDigit {

	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int result = A * B * C;
		
		int[] cnts = new int[10];
		
		if( result == 0) cnts[0] = 1;
		else{
			while(result != 0)
			{
				cnts[ result % 10]++;
				result = result/10;
			}
		}
		
		for(int val: cnts)
			System.out.println(val);
		
	}
}
