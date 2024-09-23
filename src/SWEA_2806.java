import java.util.*;

public class SWEA_2806 {
	static int[] arr; // 각 행에 퀸이 놓인 열의 인덱스 저장
	static int sum; // 퀸을 배치하는 방법의 수
	
	public static void dfs(int start, int n) {
		// 종료 조건 : 모든 행에 퀸을 성공적으로 배치했다면
		if (start == n) {
			sum += 1;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			boolean check = true; // 현재 열에 퀸을 놓을 수 있는 지에 대한 여부
			for (int j = 0; j < start; j++) {
				// 같은 열에 퀸이 있는 지
				// 왼쪽 방향 대각선에 퀸이 있는 지
				// 오른쪽 방향 대각선에 퀸이 있는 지
				if (arr[j] == i || arr[j] + (start - j) == i || arr[j] - (start - j) == i) {
					check = false;
					break;
				}
			}
			
			if (check) {
				arr[start] = i;
				dfs(start + 1, n);
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			sum = 0;
			arr = new int[n];
			
			dfs(0,n);
			System.out.println("#" + test_case + " " + sum);

		}
		sc.close();
	}
}
