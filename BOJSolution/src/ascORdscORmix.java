// À½°è - https://www.acmicpc.net/problem/2920
import java.util.*;

public class ascORdscORmix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean asc = true, dsc = true;
		int prev, cur;
		
		prev = sc.nextInt();
		
		for(int i = 0; i < 7; i++)
		{
			cur = sc.nextInt();
			
			if(prev > cur) asc = false;
			else dsc = false;
			prev = cur;
		}
		if(asc) System.out.println("ascending");
		else if(dsc) System.out.println("descending");
		else System.out.println("mixed");
	}

}
