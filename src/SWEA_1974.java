import java.util.*;
import java.io.FileInputStream;

public class SWEA_1974 {
	public static void main(String args[]) throws Exception
	{
		int[][] map = new int[9][9];
		
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
			int answer = 1;
			
			// 스도쿠 입력
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 행, 열 검사
			for (int i = 0; i < 9; i++) {
				int rowSum = 0;
				int colSum = 0;
				for (int j = 0; j < 9; j++) {
					rowSum += map[i][j];
					colSum += map[j][i];
				}
				
				// 합이 45가 아니라면
				if (rowSum != 45 || colSum != 45) {
					answer = 0;
					break;
				}
			}
			

			
			// 3 x 3 정사각형에 1~9의 수가 있는 지 검증
			for (int i = 1; i <= 3; i++) {
				int squareSum = 0;
				for (int j = (i - 1)* 3; j < i * 3; j++) {
					for (int k = (i - 1)*3; k < i * 3; k++) {
						squareSum += map[j][k];
					}
				}
				if (squareSum != 45) {
					answer = 0;
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);

			

		}
		sc.close();
	}
}
