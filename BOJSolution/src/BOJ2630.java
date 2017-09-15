import java.util.Scanner;

public class BOJ2630 {
	static int[][] MAP = new int[128][128];
	static int N;
	static int white, blue;
	
	static void divide(int x, int y, int size){
		if(size == 1){
			if(MAP[x][y] == 0) white++;
			else blue++;			
			return;
		}
		int w = 0;
		for(int i = x; i < x + size; i++)
		{
			for(int j = y; j < y + size; j++)
			{
				if(MAP[i][j] == 0) w++;
			}
		}
		int b = size*size - w;
		if(w == size*size){
			white++;			
		}else if(b == size*size){
			blue++;			
		}else{
			int half = size >> 1;
			divide(x, y, half);
			divide(x + half, y, half);
			divide(x, y + half, half);
			divide(x + half, y + half, half);
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				MAP[i][j] = sc.nextInt();
		}
		
		divide(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
		
		sc.close();		
	}
}
