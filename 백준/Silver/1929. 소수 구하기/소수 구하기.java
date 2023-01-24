

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		
		boolean arr[] = new boolean [N+1];
		for(int i = 0; i<=N; i++)
			arr[i] = false;
		
		arr[0] = arr[1] = true;
		
		for(int i = 2; i<=Math.sqrt(N); i++) {
			
			if(arr[i] == true)
				continue;
			
			for(int j = i*i; j < arr.length; j = j+i) {
				arr[j] = true;
			}
			
			
		}
		
		for(int i = M; i<=N; i++) {
			if(arr[i]==false)
			System.out.println(i);
		}	

	}

}
