// 간단한 소인수분해
import java.util.Scanner;

public class SWEA_1945 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int[] arr = {2, 3, 5, 7, 11};
			int[] answer = {0, 0, 0, 0, 0};
			int N = sc.nextInt();
			
			while (N > 1){
				for (int i = 0; i < arr.length; i++) {
					while (N % arr[i] == 0) {
						N /= arr[i];
						answer[i]++;
					}
				}
			}
			
			output.append("#" + test_case + " ");
			for (int i = 0; i < arr.length; i++) {
				output.append(answer[i] + " ");
			}
			output.append("\n");
		}
		System.out.println(output.toString());
		sc.close();
	}
}
