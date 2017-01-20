
public class Generation {
	static char[] str;
	static char[] order;
	static char[] selection;
	static int cnt = 0;
	
	public static void swap(int i, int j)
	{
		char t = str[i]; str[i] = str[j]; 
		str[j] = t;		
	}
//	public static void perm(int k, int n, int r)
//	{
//		if(k == r)
//		{
//			System.out.printf("%3d ", ++cnt);
//			for(int i = 0; i < k; i++)
//				System.out.print(str[i]);
//			System.out.print('\n');
//			return;
//		}
//		for(int i = k; i < n; i++)
//		{
//			swap(k, i);
//			perm(k + 1, n, r);
//			swap(k, i);
//		}
//	}
	public static void perm(int k, int n, int r, int visit)
	{
		if(k == r)
		{
			System.out.printf("%3d ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(order[i]);
			System.out.print('\n');
			return;
		}
		for(int i = 0; i < n; i++)
		{
			if( (visit & (1 << i)) != 0) continue;
			order[k] = str[i];
			perm(k + 1, n, r, visit | (1 << i));
			
		}
	}
	public static void perm_re(int k, int n, int r)
	{
		if(k == r)
		{
			System.out.printf("%3d ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(order[i]);
			System.out.print('\n');
			return;
		}
		for(int i = 0; i < n; i++)
		{
			order[k] = str[i];
			perm_re(k + 1, n, r);
		
		}
	}
	public static void comb(int k, int n, int r, int start)
	{
		if(k == r)
		{
			System.out.printf("%3d ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(order[i]);
			System.out.print('\n');
			return;
		}
		for(int i = start; i < n; i++)
		{
			order[k] = str[i];
			comb(k + 1, n, r, i + 1);
		
		}
	}
	public static void comb(int n, int r)
	{
		if(r == 0)
		{
			System.out.printf("%3d ", ++cnt);
			for(int i = 0; i < 3; i++)
				System.out.print(selection[i]);
			System.out.print('\n');
			return;
		}
		if( n < r) return;
		selection[r - 1] = str[n - 1];
		comb(n - 1, r - 1);
		comb(n - 1, r);
	}
	public static void comb_re(int k, int n, int r, int start)
	{
		if(k == r)
		{
			System.out.printf("%3d ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(order[i]);
			System.out.print('\n');
			return;
		}
		for(int i = start; i < n; i++)
		{
			order[k] = str[i];
			comb_re(k + 1, n, r, i);
		
		}
	}
	public static void subset(int k, int n)
	{
		if(k == n)
		{
			System.out.printf("%3d ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.printf("%d", (int)order[i]);
			System.out.print(' ');
			for(int i = 0; i < k; i++)
				if(order[i] != 0) 
					System.out.printf("%c ", str[i]);
			System.out.print('\n');
			return;
		}
		order[k] = 1; subset(k + 1, n);
		order[k] = 0; subset(k + 1, n);
		
	}
	public static void subset_iter(int N)
	{
/*		for(int i = 0; i < (1 << N); i++)
		{
			for(int bit = 0; bit < N; bit++)
			{
				if((i & (1 << bit)) != 0) System.out.print(bit + " ");
				else System.out.print("  ");
			}
			System.out.print("|");
			for(int bit = 0; bit < N; bit++)
			{
				if((i & (1 << bit)) != 0) 
					System.out.print(str[bit] + " ");
			}
			System.out.println();
		}*/
		
		int[] bits = new int[N];
		for(int i = 0; i < 2; i++)
		{
			bits[0] = i;
			for(int j = 0; j < 2; j++)
			{
				bits[1] = j;
				for(int k = 0; k < 2; k++)
				{
					bits[2] = k;
					System.out.println(bits[0]+" " +bits[1]+" "+ bits[2]+" " );
				}
			}			
		}
	}
	public static void main(String[] args)
	{
		String tmp = new String("ABCDE");
		str = new char[5];
		order = new char[5];
		selection = new char[5];
		str = tmp.toCharArray();
		
		//perm(0, 5, 3);
		perm(0, 5, 3, 0);
//		cnt = 0; perm_re(0, 5, 3);
//		cnt = 0; comb(0, 5, 3, 0);
//		cnt = 0; comb(5, 3);
//		cnt = 0; comb_re(0, 5, 3, 0);
//		cnt = 0; subset(0, 3);
//		cnt = 0; subset_iter(3);
	}
}
