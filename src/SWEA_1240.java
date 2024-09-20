import java.util.*;

public class SWEA_1240 {
	static int[][] codeMap;
	static String[] codes = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
	static int answer;
	
	public static void validKey(ArrayList<Integer> answerKey) {
		int sumH = 0;
		int result = 0;
		for (int i = 0; i < answerKey.size(); i+=2) {
			sumH += answerKey.get(i);
		}
	
		result = sumH * 3;
		for (int i = 1; i < answerKey.size(); i+=2) {
			result += answerKey.get(i);
		}
		if (result % 10 == 0) {
			for (int i = 0; i < answerKey.size(); i++) {
				answer += answerKey.get(i);
			}
		}
		

		return;
	}
	
	
	public static void findKey(int a, int b) {
		ArrayList<Integer> answerKey = new ArrayList<Integer>();
		for (int i = b; i < b + 56; i+=7) {
			StringBuilder inputKey = new StringBuilder("");
			for (int j = i; j < i + 7; j++) {
				inputKey.append(codeMap[a][j]);
			}
			for (int k = 0; k < 10; k++) {
				if (inputKey.toString().equals(codes[k])) {
					answerKey.add(k);
				}
			}
		}
		for (int value : answerKey) {
			System.out.println(value);
		}

		
		validKey(answerKey);
		return;
	}
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{

			int n = sc.nextInt();
			int m = sc.nextInt();
			
			codeMap = new int[n][m];
			answer = 0;
			
			
			for (int i = 0; i < n; i++) {
				String input = sc.next();
				for (int j = 0; j < m; j++) {
					codeMap[i][j] = input.charAt(j) - '0';
				}
			}
			
			
			loopOut:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					StringBuilder compareKey = new StringBuilder("");
					for (int k = j; k < j + 7; k++) {
						if (k < m) {
							compareKey.append(Integer.toString(codeMap[i][k]));
						}
					}
					
					for (int k = 0; k < 8; k++) {
						if (compareKey.toString().equals(codes[k])) {

							findKey(i, j);
							System.out.println("#" + test_case + " " + answer);
							break loopOut;
						}
					}
				}
			}

		}
		sc.close();

	}
}
