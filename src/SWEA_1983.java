import java.util.*;
import java.io.FileInputStream;

public class SWEA_1983 {
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
			String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
			int n = sc.nextInt(); // 학생 수
			Double[] score = new Double[n];
			int k = sc.nextInt(); // 원하는 학생
			
			// 점수 입력
			for (int i = 0; i < n; i++) {
				double mid = sc.nextDouble(); // 중간
				double fin = sc.nextDouble(); // 기말
				double rep = sc.nextDouble(); // 과제
				score[i] = mid * 0.35 + fin * 0.45 + rep * 0.2;
			}
			
			// 등수 구하기
			double kRank = 1;
			double kScore = score[k - 1];
			
			for (int i = 0; i < n; i++) {
				if (score[i] > kScore) {
					kRank++;
				}
			}

			// 학점 구하기
			kRank = Math.ceil(kRank / (n / 10));
			System.out.println("#" + test_case + " " + grade[(int)kRank - 1]);
		}
		sc.close();
	}
}
