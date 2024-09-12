import java.util.Scanner;

public class SWEA_1244 {
	static int[] arr;
	static int chance;
	static int max;
	
	public static void dfs(int depth) {
        if (depth == chance) {
            int result = 0;
            for (int i = 0; i < arr.length; i++) {
                result += (Math.pow(10, i) * arr[arr.length - i - 1]);
            }
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // 자리 바꾸기
                swap(i, j);
                
                // 재귀 호출
                dfs(depth + 1);
                
                // 원래 상태로 되돌리기
                swap(i, j); // 백트래킹
            }
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
			String input = sc.next();
			arr =  new int[input.length()];
			chance = sc.nextInt();
			for (int i = 0; i < input.length(); i++) {
				arr[i] = input.charAt(i) - '0';
			}
			
			if (arr.length < chance) {
				chance = arr.length;
			}
			max = 0;

			dfs(0);
			System.out.println("#" + test_case + " " + max);
		}
		sc.close();
	}
}
