// Æò±ÕÁ¡¼ö - https://www.acmicpc.net/problem/10039
import java.util.*;

public class AvgScore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0, score;
		
		for(int i = 0; i < 5; i++)
		{
			score = sc.nextInt();
			
			if(score < 40) sum += 40;
			else sum += score;
		}
		
		System.out.println(sum/5);
		
		sc.close();
	}

}
