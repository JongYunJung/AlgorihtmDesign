import java.math.BigDecimal;
import java.util.*;

public class BOJ10827 {

	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		BigDecimal a = new BigDecimal(sc.next());
		int b =sc.nextInt();		
		
		System.out.println(a.pow(b).toPlainString());
		
		sc.close();
	}
}
