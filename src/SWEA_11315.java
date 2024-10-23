// 오목 판정
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_11315 {
	static int N;
	static char[][] map;
	static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
	static boolean isOmok;
	static int count;
	
	private static void omok(int a, int b) {	
		for (int i = 0; i < 8; i++) {
			count = 1;
			int newA = a + step[i][0];
			int newB = b + step[i][1];
			while (true) {
				if (newA >= N || newA < 0 || newB >= N || newB < 0) {
					break;
				}
				
				if (map[newA][newB] == 'o') {
					count++;
					newA += step[i][0];
					newB += step[i][1];
				}
				else if (map[newA][newB] == '.') {
					break;
				}
			}
			if (count >= 5) {
				isOmok = true;
				return;
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new char[N][N];
			isOmok = false;
			
			// 돌 입력
			for (int i = 0; i < N; i++) {
				String input = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			
			Omok:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (isOmok) {
						break Omok;
					}
					if (map[i][j] == 'o') {
						omok(i, j);
					}
				}
			}
			
			if (isOmok) {
				System.out.println("#" + test_case + " YES");
			}
			else {
				System.out.println("#" + test_case + " NO");
			}
		}
		sc.close();
	}
}
