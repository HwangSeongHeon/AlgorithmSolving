import java.io.*;
import java.util.StringTokenizer;


public class Solution {
	static int [] mvr = {-1, 1, 0, 0};
	static int [] mvc = {0, 0 ,-1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= t; tc ++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][m];
			int[][] traceMap = new int[n][m];
			
			for(int i = 0; i < n; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int [][] v = new int[n][m];
			v[R][C] = 1;
			traceMap[R][C] = 1;
			goNext(R, C, n, m, L, 1, map, v, traceMap);
			int answer = 0;
			
			for(int i = 0; i < n ; i++) {
				for(int j = 0; j < m; j ++) {
					if(traceMap[i][j] == 1) {
						answer++;
					}
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		
	}

	
	private static void goNext(int r, int c, int n, int m, int L, int count, int [][] map, int [][] v, int[][] traceMap) {
		
		if(count == L) {
			return;
		}
		
		for(int i = 0; i < 4; i ++) {
			int nr = r + mvr[i];
			int nc = c + mvc[i];

			if(isIn(nr, nc, n, m) && isTunnel(nr, nc, map) && canGoNextWithType(map[r][c], i) && canGoNextWithType(map[nr][nc], nextInputDirection(i))) {
				if(v[nr][nc] == 0) {
					v[nr][nc] = 1;
					traceMap[nr][nc] = 1;
					goNext(nr, nc, n, m, L, count + 1, map, v, traceMap);
					v[nr][nc] = 0;
				}
			}
			
		}
		
	}
		// 0 -> 1
		// 1 -> 0
		// 2 -> 3
		// 3 -> 2
	
	private static int nextInputDirection(int d) {
		if(d == 0) {
			return 1;
		}
		if(d == 1) {
			return 0;
		}
		if(d == 2) {
			return 3;	
		}
		if(d == 3) {
			return 2;
		}
		throw new RuntimeException();
	}
	
	private static boolean isTunnel(int r, int c, int[][] map) {
		return map[r][c] != 0;
	}
	
	private static boolean isIn(int r, int c, int n, int m) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
	
	
	private static boolean canGoNextWithType(int type, int d) {
		if(type == 1) {
			return true;
		}
		if(type == 2) {
			if(d == 0 || d == 1) {
				return true;
			}
			return false;
		}
		if(type == 3) {
			if(d == 2 || d == 3) {
				return true;
			}
			return false;
		}
		
		if(type == 4) {
			if(d == 0 || d == 3) {
				return true;
			}
			return false;
		}
		
		if(type == 5) {
			if(d == 1 || d == 3) {
				return true;
			}
			return false;
		}
		
		if(type == 6) {
			if(d == 1 || d == 2) {
				return true;
			}
			return false;
		}
		
		if(type == 7) {
			if(d == 0 || d == 2) {
				return true;
			}
			return false;
		}
		throw new RuntimeException();
	}
}
