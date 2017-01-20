
public class DisjointSetDemo {
	static int[] p = null;
	static int[] r = null;
	
	public static void make_set(int N)
	{
		for(int i = 1; i <= N; i++)
			p[i] = i;
	}
	public static int find_set(int x)
	{
		if( x == p[x]) return x;
		else return find_set(p[x]);
	}
	public static void union(int x, int y)
	{
		p[find_set(y)] = find_set(x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p = new int[11];
		make_set(10);
		print_set(10);
		
		union(1, 3); union(2, 10); union(7, 5); union(3, 7); union(2, 8);
		
		System.out.printf("\nunion ����>\n");
		print_set(10);
		
		System.out.println("3�� ���� -->" + find_set(3));
		System.out.println("8�� ���� -->" + find_set(8));
		
	}
	public static void print_set(int N)
	{
		for(int i = 1; i <= N; i++)
			System.out.printf("%2d ", i);
		System.out.printf("\n---------------------------------------\n");
		for(int i = 1; i <= N; i++)
			System.out.printf("%2d ", p[i]);
		System.out.println();
	}
}