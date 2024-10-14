// 재미있는 오셀로 게임
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;

public class SWEA_4615 {
	static int n;
	static int m;
	static int[][] map;
	static int[][] see = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	
	private static void put (int a, int b, int dol) {
		map[a][b] = dol; // 돌 놓기
		for (int i = 0; i < 8; i++) {
			Queue<int[]> queue  = new LinkedList<>();
			int newA = a + see[i][0];
			int newB = b + see[i][1];
			
			while (newA >= 0 && newA < n && newB >= 0 && newB < n) {
				if (map[newA][newB] == 0) {
					break; // 빈 칸이면 종료
				}
				else if (map[newA][newB] == dol) {
					// 같은 색의 돌을 만나면
					while (!queue.isEmpty()) {
						int[] eat = queue.poll();
						map[eat[0]][eat[1]] = dol; // 따먹기
					}
					break;
				}
				else {
					queue.add(new int[] {newA, newB});
				}
				newA += see[i][0];
				newB += see[i][1];
			}
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
		System.setIn(new FileInputStream("res/input.txt"));

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
			n = sc.nextInt();
			map = new int[n][n];
			m = sc.nextInt();
			
			// 지도 초기화
			switch (n) {
			case 4:
				map[1][1] = 2;
				map[1][2] = 1;
				map[2][1] = 1;
				map[2][2] = 2;
				break;
			case 6:
				map[2][2] = 2;
				map[2][3] = 1;
				map[3][2] = 1;
				map[3][3] = 2;
				break;
			case 8:
				map[3][3] = 2;
				map[3][4] = 1;
				map[4][3] = 1;
				map[4][4] = 2;
				break;
			}
			
			for (int i = 0; i < m; i++) {
				int b = sc.nextInt(); // 열
				int a = sc.nextInt(); // 행
				int dol = sc.nextInt(); // 1:흑돌, 2:백돌
				
				if (dol == 1 || dol == 2) {
					put(a-1, b-1, dol);

				}

			}
			
			int white = 0;
			int black = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						black++;
					}
					else if (map[i][j] == 2){
						white++;
					}
				}
			}
			System.out.println("#" + test_case + " " + black + " " + white);
			
		}
		
		sc.close();
	}
}
