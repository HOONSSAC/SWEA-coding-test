// 지그재그 숫자
import java.util.Scanner;

public class SWEA_1986 {
	public static void main(String argsp[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				if (i % 2 == 0) {
					sum -= i;
				}
				else {
					sum += i;
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
		sc.close();
	}
}
