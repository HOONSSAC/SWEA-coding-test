// 비밀번호
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1234 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream ("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			@SuppressWarnings("unused")
			int size = sc.nextInt();
			String inputString = sc.next();
			StringBuilder output = new StringBuilder();
			output.append(inputString);
			int left = 0;
			int right = 1;
			
			while (left >= 0 && right < output.length()) {
				if (output.charAt(left) == output.charAt(right)) {
					output.delete(left, right + 1);
					if (left > 0) {
						left--;
						right--;
					}
				}
				else {
					left++;
					right++;
				}
			}
			System.out.println("#" + test_case + " " + output.toString());
		}
		sc.close();
	}
}
