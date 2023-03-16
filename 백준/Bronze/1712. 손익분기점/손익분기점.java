

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[3];
		
		for(int i = 0; i<3; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		if(arr[2]-arr[1] > 0) {
		  int n = arr[0]/(arr[2]-arr[1]);
		  System.out.println(n+1);
			
		}
		
		else {
			System.out.println(-1);
		}

	}

}
