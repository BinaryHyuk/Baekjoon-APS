import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int row;
	static int col;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int shopCnt = Integer.parseInt(br.readLine());
		arr = new int[shopCnt+1];
		
		for (int i = 0; i < shopCnt + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			setPosition(i, dir, pos);
		}
		int sum = 0;
		for(int i = shopCnt - 1; i >= 0; i--) {
			sum += shortLength(Math.abs(arr[shopCnt] - arr[i]));
		}
		System.out.println(sum);
	}
	static void setPosition(int idx, int dir, int pos) {
		switch(dir) {
		case 1:
			arr[idx] = pos;
			break;
		case 2:
			arr[idx] = 2 * row + col - pos;
			break;
		case 3:
			arr[idx] = 2 * (row + col) - pos;
			break;
		case 4:
			arr[idx] = row + pos;
			break;
		}
	}


	static int shortLength(int length) {
		int totalLen = 2 * (row + col);
		//int len = Math.min(length, totalLen - length);
		int len = (length > row + col) ? totalLen - length : length;
		return len;
	}
}
