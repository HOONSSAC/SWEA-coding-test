import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1959 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);


		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int max = 0;
			
			int[] arrA = new int[n];
			int[] arrB = new int[m];
			
			for (int i = 0; i < n; i++) {
				arrA[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				arrB[i] = sc.nextInt();
			}
			
			if (n < m) {
				for (int i = 0; i <= Math.abs(n-m); i++) {
					int temp = 0;
					for (int j = 0; j < arrA.length; j++) {
						temp += (arrA[j] * arrB[i + j]);
					}
					max = Math.max(max,  temp);
				}
			}
			else {
				for (int i = 0; i < Math.abs(n-m); i++) {
					int temp = 0;
					for (int j = 0; j < arrB.length; j++) {
						temp += (arrB[j] * arrA[i + j]);
					}
					max = Math.max(max,  temp);
				}
			}
			
			
			System.out.println("#" + test_case + " " + max);
		}
		sc.close();
	}
}
