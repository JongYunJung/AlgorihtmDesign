import java.util.Scanner;

public class BOJ2447 {
	 
	static char[][] data = new char[2187][2187];
	
	static void printStar(int x, int y, int size, boolean space){
		if(space){
			for(int i = 0; i < size; i++)
				for(int j = 0; j < size; j++){
					data[x + i][y + j] = ' ';
				}
			return;
		}else{
			if(size == 1){
				data[x][y] = '*';
			}else{
				int len = size / 3;
				for(int i = 0; i < 3; i++){
					for(int j = 0; j < 3; j++){
						if(i == 1 && j == 1) 
							printStar(x + i*len, y + j*len, len, true);
						else
							printStar(x + i*len, y + j*len, len, false);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		printStar(0, 0, N, false);
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(data[i][j]);
			}
			System.out.println();
		}	
		sc.close();
	}

}
