import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [][] h = new int[n][2];
		
		
		for(int i = 0; i < n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h[i][0] = Integer.parseInt(st.nextToken());
			h[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(h, (a1, a2) -> {
			if(a1[1] == a2[1]) {
				return  a1[0] - a2[0];
			}
			return a1[1] - a2[1];
		});
		
		
		int curE = 0;
		
		int cnt = 0;
		for(int i = 0; i < n; i ++) {
			if(h[i][0] >= curE) {
				curE = h[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
