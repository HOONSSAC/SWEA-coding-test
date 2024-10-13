// 암호문3
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1230 {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int size = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			
			// 초기 암호문 입력
			for (int i = 0; i < size; i++) {
				list.add(sc.nextInt());
			}
			
			size = sc.nextInt();
			
			for (int i = 0; i < size; i++) {
				char command = sc.next().charAt(0);
				switch (command) {
				case 'I':
					int point = sc.nextInt();
					int count = sc.nextInt();
					for (int j = 0; j < count; j++) {
						list.add(point, sc.nextInt());
						point++;
					}
					break;
				case 'D':
					int point1 = sc.nextInt();
					int count1 = sc.nextInt();
					for (int j = 0; j < count1; j++) {
						list.remove(point1);
					}
					point1++;
					break;
				case 'A':
					int count2 = sc.nextInt();
					for (int j = 0; j < count2; j++) {
						list.addLast(sc.nextInt());
					}
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
