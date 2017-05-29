import java.util.*;

public class BOJ11728 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[M];
		
		for(int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		for(int i = 0; i < M; i++)
			B[i] = sc.nextInt();
		
		int i = 0, j = 0;
		
		while(i < N && j < M)
		{
			if(A[i] <= B[j]) 
			{
				System.out.print(A[i++] + " ");
			}else{
				System.out.print(B[j++] + " ");
			}
		}
		if(i == N)
			while(j < M) System.out.print(B[j++] + " ");
		
		if(j == M)
			while(i < N) System.out.print(A[i++] + " ");
		
	}
}