import java.math.BigDecimal;
import java.util.*;

public class BOJ10827 {

	static BigDecimal exp(BigDecimal a, int b)
	{
		if(b == 0) return new BigDecimal(1.0);
		if(b == 1) return a;
		if((b & 1) == 0)
		{
			BigDecimal  ret = exp(a, b/2);
			return ret.multiply(ret);
		}else{
			BigDecimal  ret = exp(a, (b - 1)/2);
			return ret.multiply(ret).multiply(a);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		BigDecimal a = new BigDecimal(sc.nextDouble());
		int b = sc.nextInt();
		
		BigDecimal ret = exp(a, b);
		System.out.println(ret.toString());
		sc.close();
	}
}
