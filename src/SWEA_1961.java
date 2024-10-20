import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1961 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int[][] map90 = new int[N][N];
			int[][] map180 = new int[N][N];
			int[][] map270 = new int[N][N];

			// 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 90도 회전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map90[i][j] = map[N-j-1][i];
				}
			}
			
			// 180도 회전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map180[i][j] = map[N-i-1][N-j-1];
				}
			}
			
			// 270도 회전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map270[i][j] = map[j][N-i-1];
				}
			}
			
			// 결과 출력
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < N; k++) {
					System.out.print(map90[i][k]);
				}
				System.out.print(" ");

				for (int k = 0; k < N; k++) {
					System.out.print(map180[i][k]);
				}
				System.out.print(" ");

				for (int k = 0; k < N; k++) {
					System.out.print(map270[i][k]);
				}
				System.out.println();
				
			}
		}
		sc.close();
	}
}
