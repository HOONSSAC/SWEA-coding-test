import java.util.*;

public class SWEA_1954 {
	static int[][] map;
	static int size;
	static int[][] step = {{0,1},{1,0},{0,-1},{-1,0}}; // 우 하 좌 상
	
	public static void dfs(int a, int b, int value, int dir) {
		map[a][b] = value;
		
		if (value == size * size || dir == 4) {
			return;
		}
		
		int newA = a + step[dir][0];
		int newB = b + step[dir][1];
		
		// 새로운 위치가 유효한지 확인
		if (newA >= 0 && newA < size && newB >= 0 && newB < size && map[newA][newB] == 0) {
			dfs(newA, newB, value+1, dir);
		}
		else {
			// 방향 전환
			dir = (dir + 1) % 4; // 방향을 시계방향으로 전환
			newA = a + step[dir][0];
			newB = b + step[dir][1];
			
			// 새로운 방향으로 이동
			if (newA >= 0 && newA < size && newB >= 0 && newB < size && map[newA][newB] == 0) {
				dfs(newA, newB, value + 1, dir);
			}
		}

		

	}
	
	public static void printMap() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			size = sc.nextInt();
			map = new int[size][size];
			dfs(0, 0, 1, 0);
			System.out.println("#" + test_case);
			printMap();
		}
		
		sc.close();
	}
}
