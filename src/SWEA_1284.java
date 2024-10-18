// 수도 요금 경쟁
import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1284 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream ("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int r = sc.nextInt();
			int s = sc.nextInt();
			int w = sc.nextInt();
			
			int cpA = p * w;
			int cpB = q;
			
			if (w > r) {
				cpB += ((w - r) * s);
			}
			
			System.out.println("#" + test_case + " " + Math.min(cpA, cpB));
		}
		sc.close();
	}
}
