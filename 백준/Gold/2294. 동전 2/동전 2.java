import java.io.*;
import java.util.*;


public class Main {
	
	static int n;
	static int k;
	static int [] coin;
	static int [] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		coin = new int[n];
		
		for(int i = 0; i < n; i ++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
	
		dp = new int[k + 1];
		Arrays.fill(dp, 100 * 100_000);
		dp[0] = 0;
		for(int i = 0; i < n; i ++) {
			for(int j = 1; j <= k; j ++) {
				if(coin[i] <= j) {
					dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);
				}
			}
		}
		
		System.out.println(dp[k] == 100 * 100_000 ? -1 : dp[k]);
	}
}
