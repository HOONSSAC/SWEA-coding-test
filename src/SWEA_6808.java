// 규영이와 인영이의 카드게임
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_6808 {
	static int[] kyu;
	static int[] iny;
	static boolean[] all;
	static int[] output;
	static boolean[] visited;
	static int win;
	static int lose;
	
	private static void fight() {
		int kyuScore = 0;
		int inyScore = 0;
		
		for (int i = 0; i < 9; i++) {
			if (kyu[i] > output[i]) {
				kyuScore += (kyu[i] + output[i]);
			}
			else if (kyu[i] < output[i]) {
				inyScore += (kyu[i] + output[i]);
			}
		}
		
		if (kyuScore > inyScore) {
			win++;
		}
		else if (kyuScore < inyScore) {
			lose++;
		}
	}
	
	private static void permutation(int depth) {
		if (depth == 9) {
			fight();
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = iny[i];
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			// 1 ~ 18 카드 존재
			// 9장씩 분배, 9라운드 진행
			// 한 장씩 카드 드로우
			// 높은 수가 적힌 사람 -> 두 수의 합만큼 점수 얻음
			// 총점이 더 높은 사람이 승리
			kyu = new int[9];
			iny = new int[9];
			all = new boolean[19];
			output = new int[9];
			visited = new boolean[9];
			win = 0;
			lose = 0;
			
			// 규영이 카드 입력
			for (int i = 0; i < 9; i++) {
				int temp = sc.nextInt();
				kyu[i] = temp;
				all[temp] = true;
			}
			
			// 인영이 카드 입력
			int index = 0;
			for (int i = 1; i <= 18; i++) {
				if (all[i] == false) {
					iny[index] = i;
					index++;
				}
			}
			
			permutation(0);
			System.out.println("#" + test_case + " " + win + " " + lose);
		}
		sc.close();
	}
}
