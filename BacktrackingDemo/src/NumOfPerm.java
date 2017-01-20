
public class NumOfPerm {
	static int[] nfact = new int[10];
	
	public static void calc_factorial()
	{
		nfact[1] = 1;
		for(int i = 2; i <= 8; i++)
		{
			nfact[i] = nfact[i - 1] * i;
		}
	}
	static int getIndex(int[] arr)
	{
		int ret = 0;
		for(int i = 0; i < 9; i++)
		{
			int less = 0;
			for(int j = i + 1; j < 9; j++)
				if(arr[j] < arr[i]) ++less;
			ret += nfact[9 - i - 1] * less;
		}
		return ret;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,9,8};
		
		System.out.println(getIndex(arr));

	}

}
