// 부분 수열의 합
import java.util.Scanner;

public class SWEA_2817 {
	static int[] arr;
	static int N, cnt, flag;
	
	public static void algorithm(int start, int sum) {
		if (sum > flag) {
			return;
		}
		if (start == arr.length) {
			if (sum == flag) {
				cnt++;
			}
			return;
		}
		// 사용하는 경우
		algorithm(start+1, sum + arr[start]);
		
		// 사용하지 않는 경우
		algorithm(start+1, sum);
	}
	
	public static void main (String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			arr = new int[N];
			flag = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			cnt = 0;
			algorithm(0, 0);
			System.out.println("#" + test_case + " " + cnt);

		}
		sc.close();
		
	}
}
