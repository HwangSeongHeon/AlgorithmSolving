import java.util.*;
import java.io.*;

public class Main {
	static int [][] cazes = new int[15][2];
	static int idx = 0;
	static int [][] scores;
	static boolean can;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		makeCases(new int[2], 0, 0);
		
		
		for(int t = 0; t < 4; t ++) {
			scores = new int [6][3];
			can = false;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 6; i ++) {
				for(int j = 0; j < 3; j ++) {
					scores[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			play(0);
			System.out.print((can ? 1 : 0) + " ");
		}
		
	}
	
	public static boolean check() {
		for(int i = 0; i < 6; i ++) {
			for(int j = 0; j < 3; j ++) {
				if(scores[i][j] != 0) {
					return can = false;
				}
			}
		}
		
		
		return can = true;
	}
	
	public static void play(int playCnt) {
		if(playCnt == 15) {
			check();
			return;
		}
		
		int p1 = cazes[playCnt][0];
		int p2 = cazes[playCnt][1];
	
		if(scores[p1][0] > 0 && scores[p2][2] > 0) {
			scores[p1][0] --;
			scores[p2][2] --;
			play(playCnt + 1);
			scores[p1][0] ++;
			scores[p2][2] ++;	
		}
		
		if(scores[p1][2] > 0 && scores[p2][0] > 0) {
			scores[p1][2] --;
			scores[p2][0] --;
			play(playCnt + 1);
			scores[p1][2] ++;
			scores[p2][0] ++;	
		}
		
		if(scores[p1][1] > 0 && scores[p2][1] > 0) {
			scores[p1][1] --;
			scores[p2][1] --;
			play(playCnt + 1);
			scores[p1][1] ++;
			scores[p2][1] ++;
		}
		
	}
	
	public static void makeCases(int [] temp, int cnt, int next) {
		
		if(cnt == 2) {
			cazes[idx][0] = temp[0];
			cazes[idx][1] = temp[1];
			idx++;
			return; 
		}
		
		for(int i = next; i < 6; i ++) {
			temp[cnt] = i;
			makeCases(temp, cnt + 1, i + 1);
		}
	}
}
