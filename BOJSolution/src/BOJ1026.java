// ���� https://www.acmicpc.net/problem/1026
	
import java.util.*;

public class BOJ1026 {

	static Integer[] A;
	static Integer[] B;	// �������� �������� ��ü Ÿ������
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new Integer[N];
		B = new Integer[N];
		for(int i = 0; i < N; i++)		
			A[i] = sc.nextInt(); 
		for(int i = 0; i < N; i++)		
			B[i] = sc.nextInt();

		// �������� ���� ����
		Arrays.sort(A);
		// �������� ����
		Arrays.sort(B, Collections.reverseOrder());
		int sum = 0;
		for(int i = 0; i < N; i++)
			sum += A[i] * B[i];
		System.out.println(sum);
		sc.close();
	}
}
