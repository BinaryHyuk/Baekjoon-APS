
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// dir: 0:가로, 1:대각선  ,2:세로
		count = 0;
		movePipe(0, 1, 2);
		System.out.println(count);

	}
	
	static void movePipe(int dir, int r, int c) {
		if(r < 1 ||  r > N || c < 1 || c > N || map[r][c] == 1) {
			return;
		}
		else if(r == N && c == N) {
			count++;
			return;
		}
		
		//오른쪽으로 가는 경우
		if(dir != 2)
			movePipe(0, r, c+1);
		
		//아래로 가는 경우
		if(dir != 0)
			movePipe(2, r+1, c);
		
		//대각선으로 가는 경우
		if((map[r+1][c+1] == 0) && (map[r][c+1] == 0) && (map[r+1][c] == 0))
			movePipe(1, r+1, c+1);;
		
	}
}
