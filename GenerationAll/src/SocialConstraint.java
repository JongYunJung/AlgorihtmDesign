import java.util.Scanner;

// permutation

public class SocialConstraint {
	static int[] seats = new int[8];
	static int[][] constraints = new int[20][3];
	static int N, M, cnt;
	// bit 정보를 이용해서 생성하기
	public static boolean check_constraints()
	{
		for(int i = 0; i < M; i++)
		{
			if(constraints[i][2] > 0){
				int diff = seats[constraints[i][0]] - seats[constraints[i][1]];
				diff = diff < 0? -diff: diff;
				if(diff > constraints[i][2]) return false;
			}else{
				int diff = seats[constraints[i][0]] - seats[constraints[i][1]];
				diff = diff < 0? -diff: diff;
				if(diff < -constraints[i][2] ) return false;
			}
		}
		return true;
	}
	public static void perm(int k, int visit)
	{
		if(k == N)
		{
			if(check_constraints())	cnt++;			
			return;
		}
		for(int i = 0; i < N; i++)
		{
			if( (visit & (1 << i)) != 0) continue;
			seats[k] = i;
			perm(k + 1, visit | (1 << i));
			
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			if(N == 0 && M == 0){ sc.close(); return;}
			
			for(int i = 0; i < M; i++)
			{
				constraints[i][0] = sc.nextInt();
				constraints[i][1] = sc.nextInt();
				constraints[i][2] = sc.nextInt();
			}
			cnt = 0;
			perm(0, 0);
			
			System.out.println(cnt);
		}
	}

}
