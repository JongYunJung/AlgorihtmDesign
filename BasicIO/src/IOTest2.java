import java.io.FileInputStream;
import java.util.Scanner;

public class IOTest2 {
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
				String line = sc.next();
				System.out.println(line);
			}
			sc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
