import java.io.FileInputStream;
import java.util.Scanner;

public class IOTest3 {
	public static void readData(String file)
	{
		Scanner sc; FileInputStream fin;
		try {
			if(file == null) sc = new Scanner(System.in);
			else{
				fin = new FileInputStream(file);
				sc = new Scanner(fin);
			}

			int case_num = sc.nextInt();
			System.out.println(case_num);

			for(int tc = 1; tc <= case_num ; tc++)
			{
				int N = sc.nextInt();
				System.out.println(N);
				for(int i = 0; i < N; i++)
				{
					for(int j = 0; j < N; j++)
					{
						System.out.print(sc.nextInt() + " ");
					}
					System.out.print("\n");
				}
			}
			sc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
