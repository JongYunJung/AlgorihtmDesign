
public class ArrayDemo {
	public static void main(String[] args)
	{
		int[] arr = new int[5];
		for(int i = 0; i < 5; i++)
			arr[i] = i + 1;
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		
		for(int val: arr)
			System.out.println(val);
	}
}
