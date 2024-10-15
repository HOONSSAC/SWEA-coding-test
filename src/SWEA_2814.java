// 최장경로
import java.util.Scanner;
import java.io.FileInputStream;

public class SWEA_2814 {
	static int[][] graph;
	static boolean[] visited;
	static int n;
	static int m;
	static int max;
	
	public static void dfs(int v, int count) {
		visited[v] = true;
		for (int i = 1; i <= n; i++) {
			if (graph[v][i] == 1 && !visited[i]) {
				dfs(i, count + 1);
				visited[i] = false;
			}
		}
		max = Math.max(max, count);
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			graph = new int[n+1][n+1];
			visited = new boolean[n+1];
			max = 0;
			
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph[a][b] = 1;
				graph[b][a] = 1;
			}
			
			for (int i = 1; i <= n; i++) {
				dfs(i, 1);
				visited[i] = false;
			}
			System.out.println("#" + test_case + " " + max);
		}
		sc.close();
	}
}
