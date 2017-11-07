// ���� ����
/*
add x: S�� x�� �߰��Ѵ�. (1 �� x �� 20) S�� x�� �̹� �ִ� ��쿡�� ������ �����Ѵ�.
remove x: S���� x�� �����Ѵ�. (1 �� x �� 20) S�� x�� ���� ��쿡�� ������ �����Ѵ�.
check x: S�� x�� ������ 1��, ������ 0�� ����Ѵ�.
toggle x: S�� x�� ������ x�� �����ϰ�, ������ x�� �߰��Ѵ�. (1 �� x �� 20)
all: S�� {1, 2, ..., 20} ���� �ٲ۴�.
empty: S�� ���������� �ٲ۴�. 
 */
import java.util.*;
import java.io.*;
public class BOJ11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder ans = new StringBuilder(); // ����� ��Ƽ� �ѹ��� ���
		
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
