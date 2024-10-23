// 수의 새로운 연산
import java.util.Scanner;

public class SWEA_1493 {
	private static int calculation(int p, int q) {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		
		Loop1:
		for (a = 1; a < 200; a++) {
			for (b = 1; b < 200; b++) {
				int value = 0;
				int step = 0;
				
				for (int x = 1; x <= a; x++) {
					step++;
					value += step;
				}
				for (int y = 1; y < b; y++) {
					value += step;
					step++;
				}
				
				if (value == p) {
					break Loop1;
				}
			}
		}
		
		Loop2:
		for (c = 1; c < 200; c++) {
			for (d = 1; d < 200; d++) {
				int value = 0;
				int step = 0;
				
				for (int x = 1; x <= c; x++) {
					step++;
					value += step;
				}
				for (int y = 1; y < d; y++) {
					value += step;
					step++;
				}
				
				if (value == q) {
					break Loop2;
				}
			}
		}
		
		a += c;
		b += d;
		
		int value = 0;
		int step = 0;
		
		for (int x = 1; x <= a; x++) {
			step++;
			value += step;
		}
		for (int y = 1; y < b; y++) {
			value += step;
			step++;
		}
		
		return value;		
	}
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			System.out.println("#" + test_case + " " + calculation(p, q));
		}
		sc.close();
	}
}
