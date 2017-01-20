
public class SubsetDemo {
	static char[] str;
	static boolean[] bits;	
	static int cnt = 0;
	
	public static void subset(int k, int n)
	{
		if(k == n)
		{
			System.out.printf("%3d> ", ++cnt);
			
			System.out.print(' ');
			for(int i = 0; i < k; i++)
				if(bits[i]) 
					System.out.printf("%c ", str[i]);
			System.out.print('\n');
			return;
		}
		bits[k] = true; subset(k + 1, n);
		bits[k] = false; subset(k + 1, n);
		
	}
	public static void subset_counting(int N)
	{
		for(int i = 0; i < (1 << N); i++)
		{
			System.out.printf("%3d ", ++cnt);
			for(int bit = 0; bit < N; bit++)
			{
				if((i & (1 << bit)) != 0) System.out.print(1);
				else System.out.print(0);
			}
			System.out.print("|");
			for(int bit = 0; bit < N; bit++)
			{
				if((i & (1 << bit)) != 0) 
					System.out.print(str[bit] + " ");
			}
			System.out.println();
		}
	}
	public static void subset_iter(int N)
	{
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
	public static void main(String[] args) {
		String tmp = new String("ABCDE");
		str = tmp.toCharArray();
		bits = new boolean[tmp.length()];
		subset(0, tmp.length());
		//subset_counting(tmp.length());
		
	}

}
