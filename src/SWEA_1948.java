// 날짜 계산기
import java.util.Scanner;

public class SWEA_1948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			int month_1st = sc.nextInt();
			int day_1st = sc.nextInt();
			int month_2nd = sc.nextInt();
			int day_2nd = sc.nextInt();
			
			while(month_1st < month_2nd) {
				answer += days[month_1st++];
			}
			
			answer = answer - day_1st + day_2nd + 1;
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}
