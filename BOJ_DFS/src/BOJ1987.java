import java.util.Scanner;

public class BOJ1987 {

	static String[] board;
	static boolean[] visit = new boolean[128];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int r, c;
	static int move(int x, int y)
	{
		if(visit[board[x].charAt(y)]) return 0;
		
		visit[board[x].charAt(y)] = true;
		int cnt = 1;
		for(int i = 0; i < 4; i++)
		{
			int tx = x + dx[i];
			int ty = y + dy[i];
			if(tx < 0 || tx == r || ty < 0 || ty == c) continue;
			cnt += move(tx, ty);
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		board = new String[r];
		for(int i = 0; i < r; i++)
			board[i] = sc.next();

		System.out.println(move(0, 0));

	}
}
