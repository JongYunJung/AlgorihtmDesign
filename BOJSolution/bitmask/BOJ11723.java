// 집합 연산
/*
add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다.
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다. 
 */
import java.util.*;
import java.io.*;
public class BOJ11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder ans = new StringBuilder(); // 결과를 모아서 한번에 출력
		
		int M = Integer.parseInt(st.nextToken());
		int S = 0, x;
		
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();		
			
			if(str.equals("add")){
				x = Integer.parseInt(st.nextToken());
				S = S | (1 << x);
			}else if(str.equals("remove") ){
				x = Integer.parseInt(st.nextToken());
				S = S & ~(1 << x);
			}else if(str.equals("check")){
				x = Integer.parseInt(st.nextToken());
				if( (S & (1 << x)) == 0) ans.append("0\n");
				else ans.append("1\n");
			}else if(str.equals("toggle") ){
				x = Integer.parseInt(st.nextToken());
				S = S ^ (1 << x);
			}else if(str.equals("all") ){
				S = (1 << 21) - 1;
			}else S = 0;			
		}
		System.out.println(ans);
		br.close();
	}
}
