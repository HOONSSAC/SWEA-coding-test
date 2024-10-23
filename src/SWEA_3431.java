// 준환이의 운동관리
import java.util.Scanner;

public class SWEA_3431 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) { 
			// L분 이상 U분 이하
			// X분 운동
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			int answer = 0;
			
			if (X < L) {
				answer = L - X;
			}
			else if (X > U) {
				answer = -1;
			}
			System.out.println("#" + test_case + " " + answer);	
		}
		sc.close();
	}
}
