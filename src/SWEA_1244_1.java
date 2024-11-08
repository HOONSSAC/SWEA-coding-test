// 최대 상금
import java.util.Scanner;

public class SWEA_1244_1 {
	static int[] arr;
	static int count;
	static int max;
	
	private static void dfs(int depth) {
		if (depth == count) {
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				str.append(arr[i]);
			}
			if (Integer.parseInt(str.toString()) > max) {
				max = Integer.parseInt(str.toString());
			}
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				swap(i, j);
				dfs(depth + 1);
				swap(i, j);
			}
		}
		
	}
	
    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String input = sc.next();
			count = sc.nextInt();
			arr = new int[input.length()];
			max = 0;
			
			for (int i = 0; i < input.length(); i++) {
				arr[i] = input.charAt(i) - '0';
			}
			
			if (arr.length < count) {
				count = arr.length;
			}
			
			dfs(0);
			System.out.println("#" + test_case + " " + max);
		}
	}
}
