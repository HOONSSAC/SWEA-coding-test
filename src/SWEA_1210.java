// Ladder1
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1210 {
	static int[][] map;
	static boolean[][] visited;
	static int[][] step = {{0, -1}, {0, 1}, {-1, 0}}; // 좌, 우, 상 이동
	static int answer;
	
	private static void dfs(int a, int b) {
		
		if (a == 0) {
			answer = b;
			return;
		}
			
		visited[a][b] = true;
		for (int i = 0; i < 3; i++) {
			int newA = a + step[i][0];
			int newB = b + step[i][1];
			
			if (newA >= 0 && newA < 100 && newB >= 0 && newB < 100 && !visited[newA][newB] && map[newA][newB] == 1) {
				dfs(newA, newB);
				return;
			}
		}

	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		answer = 0;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int testNum = sc.nextInt();
			map = new int[100][100];
			visited = new boolean[100][100];
			int nowA = 0;
			int nowB = 0;
			
			// 사다리 입력
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2) {
						nowA = i;
						nowB = j;
					}
				}
			}
			
			dfs(nowA, nowB);
			System.out.println("#" + testNum + " " + answer);
		}
		sc.close();
	}
}
