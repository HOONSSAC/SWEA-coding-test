// GNS
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_1221 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream ("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		HashMap<String, Integer> keyToNum = new HashMap<>();
		HashMap<Integer, String> numToKey = new HashMap<>();

		// keyToNum mapping
		keyToNum.put("ZRO", 0);
		keyToNum.put("ONE", 1);
		keyToNum.put("TWO", 2);
		keyToNum.put("THR", 3);
		keyToNum.put("FOR", 4);
		keyToNum.put("FIV", 5);
		keyToNum.put("SIX", 6);
		keyToNum.put("SVN", 7);
		keyToNum.put("EGT", 8);
		keyToNum.put("NIN", 9);
		numToKey.put(0, "ZRO");
		numToKey.put(1, "ONE");
		numToKey.put(2, "TWO");
		numToKey.put(3, "THR");
		numToKey.put(4, "FOR");
		numToKey.put(5, "FIV");
		numToKey.put(6, "SIX");
		numToKey.put(7, "SVN");
		numToKey.put(8, "EGT");
		numToKey.put(9, "NIN");
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String testNum = sc.next();
			int length = sc.nextInt();
			String[] arr = new String[length];
			for (int i = 0; i < length; i++) {
				arr[i] = sc.next();
			}
			
			for (int i = 0; i < length; i++) {
				arr[i] = keyToNum.get(arr[i]).toString();
			}
			Arrays.sort(arr);
			System.out.println(testNum);
			
			for (int i = 0; i < length; i++) {
				System.out.print(numToKey.get(Integer.parseInt(arr[i])) + " ");
				
			}
		}
		sc.close();
	}
}
