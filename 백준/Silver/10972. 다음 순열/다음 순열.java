import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N]; // n개의 수 저장 배열
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		
		if(np()) {
			for(int i = 0; i < N; i ++) {
				System.out.print(input[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println("-1");
		}
		
	}
	
	static boolean np() { // 현상태의 순열에서 사전식 다음 순열 생성후 다음 순열 존재하면  true, 아니면 false 반환
		
		// step1 : 뒤쪽부터 탐색하며 꼭대기(i) 찾기!! ==> 교환위치(i-1) 찾기 위해!!
		int i = N-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		
		if(i==0) return false; // 절벽==> 교환자리가 없다.(가장 큰 순열 형태)
		
		// step2 : i-1 교환자리의 값과 교환할 한단계 큰 수를 뒤쪽부터 찾기
		int j = N-1;
		while(input[i-1]>=input[j]) --j;
		
		// step3 : i-1자리와 j자리의 값 교환
		swap(i-1,j);
		
		// step4 : i-1자리의 한단계 큰수로 변화를 줬으니 i 꼭대기 위치부터 맨 뒤까지 가장 작은 수를 만듦(오름차순 정렬)
		int k = N-1;
		while(i<k) swap(i++,k--);
		
		return true;
	}
	
	static void swap(int i,int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
