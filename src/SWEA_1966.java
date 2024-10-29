// 숫자를 정렬하자
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1966 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
