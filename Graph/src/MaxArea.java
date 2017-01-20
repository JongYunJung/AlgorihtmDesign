import java.util.*;

public class MaxArea {	
	static int size;
	static int[][] MAP = new int[100][100];
	static boolean[][] visited = new boolean[100][100];
	
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static Queue<Pos> q1 = new LinkedList<Pos>();
	static Queue<Pos> q2 = new LinkedList<Pos>();
	
	public static class Pos{
		int x, y; 
		Pos(int _x, int _y){ x = _x; y = _y;}
	}

	public static int getMaxArea()
	{
		int maxsize = 0, cursize = 0, val;
		while(!q1.isEmpty())
		{
			Pos cur = q1.poll();
			if(visited[cur.x][cur.y]) continue;
			
			q2.add(cur);
			visited[cur.x][cur.y] = true;
			cursize = 1;
			val = MAP[cur.x][cur.y];
			
			while(!q2.isEmpty())
			{
				cur = q2.poll();
				
				for (int k = 0; k < 4; k++){
					int tmpx = cur.x + dx[k]; 
					int tmpy = cur.y + dy[k];
		
					if (tmpx < 0 || tmpx >= size) continue;
					if (tmpy < 0 || tmpy >= size) continue;
					if (MAP[tmpx][tmpy] == val && !visited[tmpx][tmpy]){
						q2.add(new Pos(tmpx, tmpy));
						visited[tmpx][tmpy] = true;
						cursize++;
					}
				}
			}
			if (maxsize < cursize) maxsize = cursize;
		}
		return maxsize;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		size = sc.nextInt();
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				MAP[i][j] = sc.nextInt();
				q1.add(new Pos(i, j));
			}
		}
		System.out.printf("최대크기> %d\n", getMaxArea());
		
		sc.close();
	}

}
