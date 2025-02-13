import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution
{
    static boolean isOk = false;
    
	public static void main(String args[]) throws Exception
	{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			isOk = false;
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] films = new int[D][W];
            for (int i = 0; i < D; i++) {
            	st = new StringTokenizer(br.readLine());
            	for (int j = 0; j < W; j++) {
                    films[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            while (answer < K) {
                injectMedicine(films, answer, 0, D, W, K);
                if (isOk) break;
                answer++;
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.print(sb.toString());
	}
    
    private static void injectMedicine(int[][] films, int count, int idx, int D, int W, int K) {
        if (isOk) return;
        if (count == 0) {
            isOk = checkFilms(films, K, D, W);
            return;
        }
        for (int i = idx; i < D; i++) {
            int[] temp = new int[W];
            for (int j = 0; j < W; j++) {
                temp[j] = films[i][j];
            }
            
            
        	for (int k = 0; k < 2; k++) {
        		for (int j = 0; j < W; j++) {
        			films[i][j] = k;
        		}
        		injectMedicine(films, count - 1, i + 1, D, W, K);
        	}
            
            for (int j = 0; j < W; j++) {
                films[i][j] = temp[j];
            }
        }
    }
    
    private static boolean checkFilms(int[][] films, int K, int D, int W) {
        for (int i = 0; i < W; i++) {
            int cont = 1;
            for (int j = 1; j < D; j++) {
                if (films[j - 1][i] == films[j][i]) {
                    cont++;
                    if (cont == K) break;
                } else {
                    cont = 1;
                }
            }
            if (cont != K) return false;
        }
        return true;
    }
}
