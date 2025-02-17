import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
	static int [] mvr = {0, -1, 0, 1, 0};
	static int [] mvc = {0, 0, 1 ,0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= t; tc ++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()); // bc
			
			int [] aMove = new int[m];
			int [] bMove = new int[m];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < m; i ++) {
				aMove[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < m; i ++) {
				bMove[i] = Integer.parseInt(st.nextToken());
			}
			
			int [][] acList = new int [a + 1][4];
			
			for(int i = 1; i <= a; i ++) {
				int [] ac = acList[i];
				st = new StringTokenizer(br.readLine());
				ac[1] = Integer.parseInt(st.nextToken());
				ac[0] = Integer.parseInt(st.nextToken());
				ac[2] = Integer.parseInt(st.nextToken());
				ac[3] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(acList, (a1, a2) -> a2[3] - a1[3]);
			
			int aR = 1;
			int aC = 1;
			int bR = 10;
			int bC = 10;
		
			int sum = 0;
			
			
			int aBoundary = getCurrentBoundary(aR, aC, acList);
			if(aBoundary >= 0) {
				int [] faBC = acList[aBoundary];
				sum += faBC[3];		
			}
			
			int bBoundary = getCurrentBoundary(bR, bC, acList);
			if(bBoundary >= 0) {
				int [] fbBC = acList[bBoundary];
				sum += fbBC[3];	
			}

			
			
			for(int i = 0; i < m; i ++) {
				
				int aMoveIdx = aMove[i];
				int anr = aR + mvr[aMoveIdx];
				int anc = aC + mvc[aMoveIdx];
				
				int bMoveIdx = bMove[i];
				int bnr = bR + mvr[bMoveIdx];
				int bnc = bC + mvc[bMoveIdx];
			
				aR = anr;
				aC = anc;
	
			
				bR = bnr;
				bC = bnc;
				
				
				aBoundary = getCurrentBoundary(aR, aC, acList);
				bBoundary = getCurrentBoundary(bR, bC, acList);
				
				int temp = 0;
				if((aBoundary == bBoundary) && aBoundary >= 0) {
					int [] ac = acList[aBoundary];
					temp = ac[3];
				}
				
				if(aBoundary >= 0) {
					int []aBC = acList[aBoundary];
					int aTemp = aBC[3];
					int bTemp = getNextBoundaryFrom(bR, bC, aBoundary,  acList);
					if(bTemp >= 0) {
						int [] bBC = acList[bTemp];
						bTemp = bBC[3];
					} else {
						bTemp = 0;
					}
					
					temp = Math.max(temp, aTemp + bTemp);
				}
				
				if(bBoundary >= 0) {
					int []bBC = acList[bBoundary];
					int bTemp = bBC[3];
					
					int aTemp = getNextBoundaryFrom(aR, aC, bBoundary,  acList);
					if(aTemp >= 0) {
						int [] aBC = acList[aTemp];
						aTemp = aBC[3];
					} else {
						aTemp = 0;
					}
					temp = Math.max(temp, aTemp + bTemp);
				}	
				sum += temp;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
		
	}
	
	private static int getNextBoundaryFrom(int curR, int curC, int from, int[][] acList) {
		if(from == -1) {
			return -1;
		}
		
		for(int i = from + 1; i < acList.length - 1; i ++) {
			int [] ac = acList[i];
			int acR = ac[0];
			int acC = ac[1];
			int c = ac[2];
			
			if(isBCBoundary(acR, acC, curR, curC, c)) {
				return i;
			}
		}
		return -1;
	}
		
	
	private static int getCurrentBoundary(int curR, int curC, int[][] acList) {
		
		for(int i = 0; i < acList.length - 1; i ++) {
			
			int [] ac = acList[i];
			int acR = ac[0];
			int acC = ac[1];
			int c = ac[2];
			
			if(isBCBoundary(acR, acC, curR, curC, c)) {
				return i;
			}
		}
		return -1;
	}
	
	private static boolean isBCBoundary(int acR, int acC, int curR, int curC, int c) {
		return Math.abs(acR - curR) + Math.abs(acC - curC) <= c;
	}
}
