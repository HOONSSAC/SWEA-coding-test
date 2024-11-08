// 의석이의 세로로 말해요
import java.util.Scanner;

public class SWEA_5356 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			char[][] arr = new char[5][15];
			int maxLength = 0;
			StringBuilder output = new StringBuilder();
			
			for (int i = 0; i < 5; i++) {
				String input = sc.next();
				if (input.length() > maxLength) {
					maxLength = input.length();
				}
				for (int j = 0; j < input.length(); j++) {
					arr[i][j] = input.charAt(j);
				}
			}
			
			for (int i = 0; i < maxLength; i++) {
				for (int j = 0; j < 5; j++) {
					if (arr[j][i] != '\0') {
						output.append(arr[j][i]);
					}
				}
			}
			System.out.println("#" + test_case + " " + output.toString());
		}
		sc.close();
	}
}
