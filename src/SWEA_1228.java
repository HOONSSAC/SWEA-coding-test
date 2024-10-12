// 암호문1

import java.util.*;
import java.io.FileInputStream;

public class SWEA_1228 {
	@SuppressWarnings("unused")
	public static void main(String args[]) throws Exception
	{
		/*
		   0 ~ 999999
		   I x y s
		   앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입
		   I 3 2 123152 487651
		   앞에서부터 3의 위치 바로 다음에 123152, 487651 삽입
		   
		   
		 */
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
				int point = sc.nextInt();
				int count = sc.nextInt();
				for (int j = 0; j < count; j++) {
					list.add(point, sc.nextInt());
					point++;
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
