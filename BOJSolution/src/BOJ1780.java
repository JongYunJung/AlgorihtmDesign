import java.util.Scanner;

public class BOJ1780 {
	static int[][] MAP;
	static int N;
	static int a, b, c;
	
	static void divide(int x, int y, int size){
		if(size == 1){
			if(MAP[x][y] == -1) a++;			
			else if(MAP[x][y] == 0) b++;
			else c++;
			return;
		}
		int cnt1 = 0, cnt2 = 0, cnt3 = 0;
		for(int i = x; i < x + size; i++)
		{
			for(int j = y; j < y + size; j++)
			{
				if(MAP[i][j] == -1) cnt1++;
				else if(MAP[i][j] == 0) cnt2++;
				else cnt3++;
			}
		}
		
		if(cnt1 == size*size) a++;
		else if(cnt2 == size*size) b++;
		else if(cnt3 == size*size) c++;	
		else{
			int t = size/3;
			divide(x, y, t); divide(x, y + t, t); divide(x, y + t*2, t);
			divide(x + t, y, t); divide(x + t, y + t, t); divide(x + t, y + t*2, t);
			divide(x + t*2, y, t); divide(x + t*2, y + t, t); divide(x + t*2, y + t*2, t);
			
			
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		MAP = new int[N][N];
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				MAP[i][j] = sc.nextInt();
		}
		
		divide(0, 0, N);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		sc.close();		
	}
}
