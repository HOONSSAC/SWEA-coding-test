// 퍼펙트 셔플
import java.util.*;

public class SWEA_3499 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			String[] arr = new String[n];
			int index = 0;
			StringBuilder output = new StringBuilder();
			output.append("#" + test_case + " ");
			
			for (int i = 0; i < n; i++) {
				arr[i] = sc.next();
			}
			
			if (arr.length % 2 == 0) {
				index = arr.length / 2;
				
				for (int i = 0; i < arr.length / 2; i++) {
					output.append(arr[i] + " " + arr[index] + " ");
					index++;
				}
			}
			else {
				index = arr.length / 2 + 1;
				
				for (int i = 0; i < arr.length / 2; i++) {
					output.append(arr[i] + " " + arr[index] + " ");
					index++;
				
				}
				output.append(arr[arr.length / 2]);
			}
			
			System.out.println(output.toString());
		}
		sc.close();
	}
}
