import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int linesToRotate = Math.min(n, m) / 2;
		
		int [][] arr = new int[n][m];
		
		for(int i = 0; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i < r; i ++) {
			for(int j = 0; j < linesToRotate; j ++) {
				int start = arr[j][j];
				
				for(int k = j + 1; k < m - j; k ++) {
					arr[j][k - 1] = arr[j][k];
				}
				for(int k = j + 1; k < n - j; k ++) {
					arr[k - 1][m - j - 1] = arr[k][m - j - 1];
				}
				for (int k = m - 2 - j; k >= j; k--) {
					arr[n - 1 - j][k + 1] = arr[n - 1 - j][k];
				}
				for (int k = n - j - 2; k >= j; k--) {
	                arr[k + 1][j] = arr[k][j];
				}
				
				arr[j + 1][j] = start;
			}
		}
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
