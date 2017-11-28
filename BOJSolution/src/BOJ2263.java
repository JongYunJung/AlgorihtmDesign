// 트리의 순회
import java.util.*;

public class BOJ2263 {
	static int[] pos1, pos2;
	static int[] in;
	static int[] post;
		
	// a: inorder 시작, b: inorder 끝
	static void preorder(int a, int b, int c, int d){
		if(a > b) return;
		
		System.out.print(post[d] + " ");
		
		int idx = pos1[post[d]];		
		int len = idx - a;
		preorder(a, idx - 1, c, c + len - 1);
		preorder(idx + 1, b, c + len, d - 1);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		pos1 = new int[N + 1];
		//pos2 = new int[N + 1];
		in = new int[N + 1];
		post = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			in[i] = sc.nextInt();			
			pos1[in[i]] = i;
		}
		for(int i = 1; i <= N; i++){
			post[i] = sc.nextInt();
			//pos2[post[i]] = i;
		}
		preorder(1, N, 1, N);
		
		sc.close();
	}

}
