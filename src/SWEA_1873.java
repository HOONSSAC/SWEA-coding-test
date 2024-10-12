// 상호의 배틀필드
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1873 {
	static int a;
	static int b;
	static char[][] map;
	static String commands;
	static char[] command;
	static int nowA;
	static int nowB;
	
	private static void execute(int num) {
		switch (command[num]) {
		case 'U':
			// 방향 위로 전환, 평지라면 이동
			map[nowA][nowB] = '^';
			if (nowA - 1 >= 0 && map[nowA - 1][nowB] == '.') {
				map[nowA][nowB] = '.';
				nowA -= 1;
				map[nowA][nowB] = '^';
			}
			break;
		case 'D':
			// 방향 아래로 전환, 평지라면 이동
			map[nowA][nowB] = 'v';
			if (nowA + 1 < a && map[nowA + 1][nowB] == '.') {
				map[nowA][nowB] = '.';
				nowA += 1;
				map[nowA][nowB] = 'v';
			}
			break;
		case 'L':
			// 방향 왼쪽으로 전환, 평지라면 이동
			map[nowA][nowB] = '<';
			if (nowB - 1 >= 0 && map[nowA][nowB - 1] == '.') {
				map[nowA][nowB] = '.';
				nowB -= 1;
				map[nowA][nowB] = '<';
			}
			break;
		case 'R':
			// 방향 오른쪽으로 이동, 평지라면 이동
			map[nowA][nowB] = '>';
			if (nowB + 1 < b  && map[nowA][nowB + 1] == '.') {
				map[nowA][nowB] = '.';
				nowB += 1;
				map[nowA][nowB] = '>';
			}
			break;
		case 'S':
			// 현재 방향으로 포탄 발사
			shoot();
			break;
		}
	}
	
	private static void shoot() {
		switch (map[nowA][nowB]) {
		case '^':
			// 위로 발사
			for (int i = nowA - 1; i >= 0; i--) {
				if (map[i][nowB] == '*') {
					map[i][nowB] = '.';
					break;
				}
				else if (map[i][nowB] == '#') {
					break;
				}
			}
			break;
		case 'v':
			// 아래로 발사
			for (int i = nowA + 1; i < a; i++) {
				if (map[i][nowB] == '*') {
					map[i][nowB] = '.';
					break;
				}
				else if (map[i][nowB] == '#') {
					break;
				}
			}
			break;
		case '<':
			// 왼쪽으로 발사
			for (int i = nowB - 1; i >= 0; i--) {
				if (map[nowA][i] == '*') {
					map[nowA][i] = '.';
					break;
				}
				else if (map[nowA][i] == '#') {
					break;
				}
			}
			break;
		case '>':
			// 오른쪽으로 발사
			for (int i = nowB + 1; i < b; i++) {
				if (map[nowA][i] == '*') {
					map[nowA][i] = '.';
					break;
				}
				else if (map[nowA][i] == '#') {
					break;
				}
			}
			break;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 맵 초기화
			a = sc.nextInt();
			b = sc.nextInt();
			map = new char[a][b];
			
			// 맵 입력
			for (int i = 0; i < a; i++) {
				String input = sc.next();
				for (int j = 0; j < b; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						nowA = i;
						nowB = j;
					}
				}
			}
			
			// 명령 입력
			int count = sc.nextInt();
			command = new char[count];
			commands = sc.next();
			for (int i = 0; i < count; i++) {
				command[i] = commands.charAt(i);
			}
			
			
			// 명령 실행
			for (int i = 0; i < count; i++) {
				execute(i);
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
